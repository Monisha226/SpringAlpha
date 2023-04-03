package com.alpha.one.service;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alpha.one.bean.OrderBean;

@Service
public class MailService {

	@Autowired
	private JavaMailSender jmsi;
	
	
	public String sendMail(OrderBean o) {
		
		SimpleMailMessage email= new SimpleMailMessage();
		
		String txt= "oderid: "+o.getOid()+ "\n mailcourse: "+o.getMaincourse()+"\n quantity: "+o.getQuantity()+"\n price: "+o.getTotal();
		email.setTo("monishacs22@gmail.com");
		email.setSubject("bill for order: "+o.getOid());
		email.setText(txt);
		
		jmsi.send(email);
		
		return "order";
	}
	
}