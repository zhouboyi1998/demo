package com.cafe.design.pattern.adapter.object;

import com.cafe.design.pattern.adapter.MailSender;
import com.cafe.design.pattern.adapter.MessageHandler;
import com.cafe.design.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.design.pattern.adapter.clazz
 * @Author: zhouboyi
 * @Date: 2024/11/1 16:22
 * @Description: 邮件发送适配器（对象适配器）
 */
public class MailObjectAdapter implements MessageHandler {

    private final MailSender mailSender;

    public MailObjectAdapter(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String content, User user) {
        mailSender.sendMail(content, user.getMail());
    }
}
