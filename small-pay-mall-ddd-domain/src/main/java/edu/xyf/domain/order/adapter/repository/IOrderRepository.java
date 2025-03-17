package edu.xyf.domain.order.adapter.repository;

import edu.xyf.domain.order.model.aggregate.CreateOrderAggregate;
import edu.xyf.domain.order.model.entity.OrderEntity;
import edu.xyf.domain.order.model.entity.PayOrderEntity;
import edu.xyf.domain.order.model.entity.ShopCartEntity;

import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 16:22
 */

public interface IOrderRepository {

    void doSaveOrder(CreateOrderAggregate orderAggregate);

    OrderEntity queryUnPayOrder(ShopCartEntity shopCartEntity);

    void updateOrderPayInfo(PayOrderEntity payOrderEntity);

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

}
