package com.cafe.pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:38
 * @Description: 通知发送器
 */
@Slf4j
public class AdviceSender {

    /**
     * 发送通知消息
     *
     * @param content 消息内容
     * @param id      目标用户ID
     */
    public void sendAdvice(String content, Long id) {
        log.info("send message [{}] to user id [{}]", content, id);
    }
}
