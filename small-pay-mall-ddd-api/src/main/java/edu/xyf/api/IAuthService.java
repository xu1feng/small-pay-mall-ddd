package edu.xyf.api;

import edu.xyf.api.response.Response;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/15 15:37
 */

public interface IAuthService {

    Response<String> weixinQrCodeTicket();

    Response<String> checkLogin(String ticket);

}
