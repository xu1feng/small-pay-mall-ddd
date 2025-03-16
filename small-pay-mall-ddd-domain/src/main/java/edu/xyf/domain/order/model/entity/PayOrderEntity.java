package edu.xyf.domain.order.model.entity;

import edu.xyf.domain.order.model.valobj.OrderStatusVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayOrderEntity {

    // 哪个用户下单的
    private String userId;

    // 下单的Id
    private String orderId;

    // 支付链接
    private String payUrl;

    // 订单状态
    private OrderStatusVO orderStatusVO;

}
