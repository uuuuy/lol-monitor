package com.uuuuy.lol.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("emailtool")
public class NotifyByMail {
	
	
	private static JavaMailSender javaMailSender;
	
	@Autowired
	public NotifyByMail(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public static void send(String address, String content) {
		MimeMessage message = null;
		try {
			message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("41611077@qq.com");
			helper.setTo(address);
			helper.setSubject("游戏通知");
			StringBuffer sb = new StringBuffer();
			sb.append(content);
			helper.setText(sb.toString(), true);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("发送失败");
		}
		
	}
	

}
