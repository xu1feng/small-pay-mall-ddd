package edu.xyf.domain.order.service;


import edu.xyf.domain.order.model.entity.PayOrderEntity;
import edu.xyf.domain.order.model.entity.ShopCartEntity;

import java.util.List;

public interface IOrderService {

    PayOrderEntity createOrder(ShopCartEntity shopCartEntity) throws Exception;

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

}
