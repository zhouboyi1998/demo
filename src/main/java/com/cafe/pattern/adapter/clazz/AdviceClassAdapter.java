package com.cafe.pattern.adapter.clazz;

import com.cafe.pattern.adapter.AdviceSender;
import com.cafe.pattern.adapter.MessageHandler;
import com.cafe.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter.clazz
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:38
 * @Description: 通知发送适配器（类适配器）
 */
public class AdviceClassAdapter extends AdviceSender implements MessageHandler {

    @Override
    public void send(String content, User user) {
        sendAdvice(content, user.getId());
    }
}
