package edu.xyf.test.domain;

import com.alibaba.fastjson.JSON;
import edu.xyf.domain.order.model.entity.PayOrderEntity;
import edu.xyf.domain.order.model.entity.ShopCartEntity;
import edu.xyf.domain.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/16 17:07
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Resource
    private IOrderService orderService;

    @Test
    public void test_createOrder() throws Exception {
        ShopCartEntity shopCartEntity = new ShopCartEntity();
        shopCartEntity.setUserId("xuyifeng");
        shopCartEntity.setProductId("100001");
        PayOrderEntity payOrderEntity = orderService.createOrder(shopCartEntity);
        log.info("请求参数: {}", JSON.toJSONString(shopCartEntity));
        log.info("测试结果: {}", JSON.toJSONString(payOrderEntity));
    }

}
