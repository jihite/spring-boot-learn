package com.jihite.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    private String to = "jihite@126.com";

    @Test
    public void testSimpleMail() {
        String subject = "测试普通邮件";
        String content = "Hello, This is a simple mail";
        mailService.sendSimpleMail(to, subject, content);
    }

    @Test
    public void testHtmlMail() {
        String subject = "测试待Html邮件";
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    public void testAttachMail() {
        String subject = "测试带附件邮件";
        String content = "请注意查收附件哦";
        String filePath = "/Users/jihite/Del/testMail";
        mailService.sendAttachMail(to, subject, content, filePath);
    }

    @Test
    public void testInlineResourceMail() {
        String subject = "带图片的邮件";
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "/Users/jihite/Downloads/abc.png";
        mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
    }

}
