package edu.xyf.api.dto;

import lombok.Data;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/17 19:26
 */
@Data
public class CreatePayRequestDTO {

    // 用户ID 【实际产生中会通过登录模块获取，不需要透彻】
    private String userId;
    // 产品编号
    private String productId;

}
