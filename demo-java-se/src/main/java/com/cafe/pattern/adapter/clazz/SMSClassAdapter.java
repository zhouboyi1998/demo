package com.cafe.pattern.adapter.clazz;

import com.cafe.pattern.adapter.MessageHandler;
import com.cafe.pattern.adapter.SMSSender;
import com.cafe.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter.clazz
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:36
 * @Description: 短信发送适配器（类适配器）
 */
public class SMSClassAdapter extends SMSSender implements MessageHandler {

    @Override
    public void send(String content, User user) {
        sendSMS(content, user.getPhone());
    }
}
