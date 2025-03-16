package edu.xyf.infrastructure.dao;

import edu.xyf.infrastructure.dao.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 19:23
 */
@Mapper
public interface IOrderDao {

    void insert(PayOrder payOrder);

    PayOrder queryUnpaidOrder(PayOrder payOrderReq);

}
