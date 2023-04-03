package com.alpha.one.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alpha.one.bean.OrderBean;
import com.alpha.one.repository.DAO;     
import com.alpha.one.repository.OrderDao;
import com.alpha.one.service.CafeService;
import com.alpha.one.service.MailService;

@Controller 
@SessionAttributes("orderb")
// use redirect:/url for redirecting to avoid multiple hits to post/put
public class AlphaController {

	@Autowired
	private CafeService service;
	
	@ModelAttribute("orderb")
    public OrderBean getbean() {  return new OrderBean(); }

	
	@RequestMapping("/login")
	public String login() { return "loginpage"; }
	
	//@ResponseBody returns data in response body
	@RequestMapping("/cafe")
	public String cafe(@ModelAttribute("orderb") OrderBean o )//Model m
			{ 

		 // OrderBean o= new OrderBean(); m.addAttribute("orderb", o);
		 
		return "cafe"; }
	
	@RequestMapping("/order-confirm")
	public String order(@Valid @ModelAttribute("orderb") OrderBean o,
			BindingResult result, HttpServletResponse res, Model m)
	{ 
		
		m.addAttribute("orderb", o);
		m.addAttribute("errmsg", "");
		
		//set error msg in error form field
		if(result.hasErrors()) {
			
			return "cafe";
			
		}
		else {
			
			//create cookie for user and add to response
			//read using @cookievaue
			
			  Cookie c=new Cookie("mycookie", o.getOid()+""); c.setMaxAge(60*24*60);
			
			 res.addCookie(c);
			
			return "order";
		}
		
	}
	
	@RequestMapping("/orderlist")
	public String orderlist(Model m) {
		
		m.addAttribute("list",service.getorderlist());
		
		return "orderlist";
		}
	
	
	@RequestMapping("/placeorder")
	public String orderplace( Model m, HttpServletRequest req) {
		 
		
	      
		OrderBean order= (OrderBean) req.getAttribute("orderb");
		System.out.println(order.getOdate());
		 String r= service.placeorder(order);
		 
		 if(r.equals("ok"))
			 return "cafe";
		 else
		 {
			 m.addAttribute("errmsg", r);
			 return "order";
		 }
		}
	
	@RequestMapping("/cancelorder")
	public String ordercancel(@Valid @ModelAttribute("orderb") OrderBean o) {
		
		
		return service.cancelorder(o.getOid());
		}
	
	@RequestMapping("/editorder")
	public String orderedit(@Valid @ModelAttribute("orderb") OrderBean o) {
		
		OrderBean eorder=service.editorder(o.getOid());
		
		return "editorder";  
		}
	
	
	
	@RequestMapping("/mailbill")
	public String mail(@ModelAttribute("orderb") OrderBean o) {
		 
		MailService ms= new MailService();
		return ms.sendMail(o);
		}
	
	
}
