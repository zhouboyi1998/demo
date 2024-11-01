package com.cafe.design.pattern.adapter.clazz;

import com.cafe.design.pattern.adapter.MailSender;
import com.cafe.design.pattern.adapter.MessageHandler;
import com.cafe.design.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.design.pattern.adapter.clazz
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:22
 * @Description: 邮件发送适配器（类适配器）
 */
public class MailClassAdapter extends MailSender implements MessageHandler {

    @Override
    public void send(String content, User user) {
        sendMail(content, user.getMail());
    }
}
