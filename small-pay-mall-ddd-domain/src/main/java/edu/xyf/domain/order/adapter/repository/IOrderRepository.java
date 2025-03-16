package edu.xyf.domain.order.adapter.repository;

import edu.xyf.domain.order.model.aggregate.CreateOrderAggregate;
import edu.xyf.domain.order.model.entity.OrderEntity;
import edu.xyf.domain.order.model.entity.ShopCartEntity;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 16:22
 */

public interface IOrderRepository {

    void doSaveOrder(CreateOrderAggregate orderAggregate);

    OrderEntity queryUnPayOrder(ShopCartEntity shopCartEntity);

}
