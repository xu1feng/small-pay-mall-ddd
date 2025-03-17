package edu.xyf.infrastructure.dao;

import edu.xyf.infrastructure.dao.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 19:23
 */
@Mapper
public interface IOrderDao {

    void insert(PayOrder payOrder);

    PayOrder queryUnpaidOrder(PayOrder payOrderReq);

    void updateOrderPayInfo(PayOrder payOrderReq);

    void changeOrderPaySuccess(PayOrder payOrderReq);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose();
}
