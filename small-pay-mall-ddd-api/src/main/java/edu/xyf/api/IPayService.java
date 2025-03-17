package edu.xyf.api;

import edu.xyf.api.dto.CreatePayRequestDTO;
import edu.xyf.api.response.Response;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/17 19:26
 */

public interface IPayService {

    Response<String> createPayOrder(CreatePayRequestDTO createPayRequestDTO);

}
