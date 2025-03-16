package edu.xyf.infrastructure.adapter.port;

import edu.xyf.domain.order.adapter.port.IProductPort;
import edu.xyf.domain.order.model.entity.ProductEntity;
import edu.xyf.infrastructure.gateway.ProductRPC;
import edu.xyf.infrastructure.gateway.dto.ProductDTO;
import org.springframework.stereotype.Component;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 16:49
 */
@Component
public class ProductPort implements IProductPort {

    private final ProductRPC productRPC;

    public ProductPort(ProductRPC productRPC) {
        this.productRPC = productRPC;
    }

    @Override
    public ProductEntity queryProductByProductId(String productId) {
        ProductDTO productDTO = productRPC.queryProductByProductId(productId);

        return ProductEntity.builder()
                .productId(productDTO.getProductId())
                .productName(productDTO.getProductName())
                .productDesc(productDTO.getProductDesc())
                .price(productDTO.getPrice())
                .build();
    }

}
