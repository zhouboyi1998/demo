package com.cafe.pattern.adapter.object;

import com.cafe.pattern.adapter.MailSender;
import com.cafe.pattern.adapter.MessageHandler;
import com.cafe.pattern.adapter.User;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.adapter.object
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
