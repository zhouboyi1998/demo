package com.cafe.pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:36
 * @Description: 短信发送器
 */
@Slf4j
public class SMSSender {

    /**
     * 发送短信消息
     *
     * @param content 消息内容
     * @param phone   目标手机号
     */
    public void sendSMS(String content, String phone) {
        log.info("send message [{}] to phone number [{}]", content, phone);
    }
}
