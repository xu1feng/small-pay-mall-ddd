package edu.xyf.domain.order.adapter.port;

import edu.xyf.domain.order.model.entity.ProductEntity;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 16:22
 */

public interface IProductPort {

    ProductEntity queryProductByProductId(String productId);

}
