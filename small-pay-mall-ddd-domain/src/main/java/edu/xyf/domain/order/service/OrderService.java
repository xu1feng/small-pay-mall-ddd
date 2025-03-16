package edu.xyf.domain.order.service;

import edu.xyf.domain.order.adapter.port.IProductPort;
import edu.xyf.domain.order.adapter.repository.IOrderRepository;
import edu.xyf.domain.order.model.aggregate.CreateOrderAggregate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 16:41
 */

@Slf4j
@Service
public class OrderService extends AbstractOrderService{

    public OrderService(IOrderRepository repository, IProductPort port) {
        super(repository, port);
    }

    @Override
    protected void doSaveOrder(CreateOrderAggregate orderAggregate) {
        repository.doSaveOrder(orderAggregate);
    }
}
