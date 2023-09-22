package com.amor.auth;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailAuth {
	@RequestMapping("member/sendMail.do")
	public ModelAndView sendMail(@RequestParam("email") String email) {
		System.out.println("이메일 : "+email);
		
		final String host = "smtp.gmail.com";
		final int port = 587;
		final String user = "projamorcinema@gmail.com"; // 보내는 사람
		final String password  = "nmyhtmboqjqekwbg";
		
		String to = email;
		
		// 세션 객체 가져오기
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.trust", host);
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		// 난수번호 초기화
		int authNum = 0;
		
		// 메일 작성
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// 메일 제목
			message.setSubject("아모르 극장 이메일 인증번호입니다. :)");
			
			// 인증번호(난수) 생성
			Random r = new Random();
			authNum = r.nextInt(888888) + 111111; // 111111~999999

			// 메일 내용
			message.setText("Dear. Amor ♥️<br>"
					+ "아모르 홈페이지를 방문해주셔서 감사합니다.<br><br>"
					+ "인증번호는 <a style='color: red;font-weight: bold'>"+authNum+"</a>입니다.<br>"
					+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.<br><br>"
					+ "감사합니다.", "UTF-8", "html");
			
			Transport.send(message);
			System.out.println("message sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		String msg = "인증번호를 전송하였습니다.";
		mav.addObject("msg", msg);
		mav.addObject("authNum", authNum);
		mav.setViewName("user/member/emailOk");
		
		return mav;
	}
}