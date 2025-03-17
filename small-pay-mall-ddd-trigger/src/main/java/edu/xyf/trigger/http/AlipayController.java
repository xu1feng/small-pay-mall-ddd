package edu.xyf.trigger.http;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import edu.xyf.api.IPayService;
import edu.xyf.api.dto.CreatePayRequestDTO;
import edu.xyf.api.response.Response;
import edu.xyf.domain.order.model.entity.PayOrderEntity;
import edu.xyf.domain.order.model.entity.ShopCartEntity;
import edu.xyf.domain.order.service.IOrderService;
import edu.xyf.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/17 19:29
 */
@Slf4j
@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/alipay/")
public class AlipayController implements IPayService {

    @Value("${alipay.alipay_public_key}")
    private String alipayPublicKey;

    @Resource
    private IOrderService orderService;

    /**
     * http://localhost:8080/api/v1/alipay/create_pay_order
     *
     * {
     *     "userId": "10001",
     *     "productId": "100001"
     * }
     */
    @RequestMapping(value = "create_pay_order", method =  RequestMethod.POST)
    @Override
    public Response<String> createPayOrder(@RequestBody CreatePayRequestDTO createPayRequestDTO) {
        try {
            log.info("商品下单，根据商品ID创建支付单开始 userId:{} productId:{}", createPayRequestDTO.getUserId(), createPayRequestDTO.getUserId());
            String userId = createPayRequestDTO.getUserId();
            String productId = createPayRequestDTO.getProductId();
            // 下单
            PayOrderEntity payOrderEntity = orderService.createOrder(ShopCartEntity.builder()
                    .userId(userId)
                    .productId(productId)
                    .build());

            log.info("商品下单，根据商品ID创建支付单完成 userId:{} productId:{} orderId:{}", userId, productId, payOrderEntity.getOrderId());
            return Response.<String>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(payOrderEntity.getPayUrl())
                    .build();
        } catch (Exception e) {
            log.error("商品下单，根据商品ID创建支付单失败 userId:{} productId:{}", createPayRequestDTO.getUserId(), createPayRequestDTO.getUserId(), e);
            return Response.<String>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

    /**
     * http://xyf-s-pay-mall.natapp1.cc/api/v1/alipay/alipay_notify_url
     */
    @RequestMapping(value = "pay_notify_url", method = RequestMethod.POST)
    public String payNotify(HttpServletRequest request) throws AlipayApiException {
        log.info("支付回调，消息接收 {}", request.getParameter("trade_status"));

        if (!request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            return "false";
        }

        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            params.put(name, request.getParameter(name));
        }

        String tradeNo = params.get("out_trade_no");
        String gmtPayment = params.get("gmt_payment");
        String alipayTradeNo = params.get("trade_no");

        String sign = params.get("sign");
        String content = AlipaySignature.getSignCheckContentV1(params);
        boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, alipayPublicKey, "UTF-8"); // 验证签名
        // 支付宝验签
        if (!checkSignature) {
            return "false";
        }

        // 验签通过
        log.info("支付回调，交易名称: {}", params.get("subject"));
        log.info("支付回调，交易状态: {}", params.get("trade_status"));
        log.info("支付回调，支付宝交易凭证号: {}", params.get("trade_no"));
        log.info("支付回调，商户订单号: {}", params.get("out_trade_no"));
        log.info("支付回调，交易金额: {}", params.get("total_amount"));
        log.info("支付回调，买家在支付宝唯一id: {}", params.get("buyer_id"));
        log.info("支付回调，买家付款时间: {}", params.get("gmt_payment"));
        log.info("支付回调，买家付款金额: {}", params.get("buyer_pay_amount"));
        log.info("支付回调，支付回调，更新订单 {}", tradeNo);

        orderService.changeOrderPaySuccess(tradeNo);

        return "success";
    }

}
