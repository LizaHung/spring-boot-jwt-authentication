package com.pet.adoption.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendEmail(String to, String subject, String messageText, byte[] file) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(messageText);
		if (file != null) {
			helper.addAttachment("領養申請書.pdf", new ByteArrayResource(file));
		}

		javaMailSender.send(mimeMessage);
	}

}
