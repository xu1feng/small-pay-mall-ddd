package edu.xyf.trigger.listener;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 支付成功回调消息
 * @create 2024-09-30 09:52
 */
@Slf4j
@Component
public class OrderPaySuccessListener {

    @Subscribe
    public void handleEvent(String paySuccessMessage) {
        log.info("收到支付成功消息，可以做接下来的事情，如；发货、充值、开户员、返利 {}", paySuccessMessage);
    }

}
