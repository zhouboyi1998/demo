package com.cafe.pattern.adapter.object;

import com.cafe.pattern.adapter.MessageHandler;
import com.cafe.pattern.adapter.SMSSender;
import com.cafe.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter.object
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:36
 * @Description: 短信发送适配器（对象适配器）
 */
public class SMSObjectAdapter extends SMSSender implements MessageHandler {

    private final SMSSender smsSender;

    public SMSObjectAdapter(SMSSender smsSender) {
        this.smsSender = smsSender;
    }

    @Override
    public void send(String content, User user) {
        smsSender.sendSMS(content, user.getPhone());
    }
}
