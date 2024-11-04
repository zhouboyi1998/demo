package com.cafe.pattern.adapter.object;

import com.cafe.pattern.adapter.AdviceSender;
import com.cafe.pattern.adapter.MessageHandler;
import com.cafe.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter.object
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:38
 * @Description: 通知发送适配器（对象适配器）
 */
public class AdviceObjectAdapter implements MessageHandler {

    private final AdviceSender adviceSender;

    public AdviceObjectAdapter(AdviceSender adviceSender) {
        this.adviceSender = adviceSender;
    }

    @Override
    public void send(String content, User user) {
        adviceSender.sendAdvice(content, user.getId());
    }
}
