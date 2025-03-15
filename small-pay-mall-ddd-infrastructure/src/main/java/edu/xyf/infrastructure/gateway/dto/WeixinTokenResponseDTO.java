package edu.xyf.infrastructure.gateway.dto;

import lombok.Data;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 获取 Access token DTO 对象
 * @create 2024-02-25 09:21
 */
@Data
public class WeixinTokenResponseDTO {

    private String access_token;
    private int expires_in;
    private String errcode;
    private String errmsg;

}
