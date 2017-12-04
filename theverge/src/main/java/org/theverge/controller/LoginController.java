package org.theverge.controller;

import java.io.IOException;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.theverge.dto.AccountsDTO;
import org.theverge.service.AccountsService;
import org.theverge.util.VerifyRecaptcha;

@Controller
public class LoginController extends HttpServlet {
	@Inject
	AccountsService accountsService;

	private long key;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println(("Login Get"));
		model.addAttribute("mode", "login");
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(Model model, String id, String password, HttpSession sess) {
		if (accountsService.getResult(id, password) > 0) {
			sess.setAttribute("id", id);
			sess.setMaxInactiveInterval(60 * 60);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("mode", "signup");
		model.addAttribute("siteKey", "6LdQQzsUAAAAALBsPKwLNOCn9bV3roG1rKUUyZ-W");
		return "/login/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(Model model, @RequestParam("g-recaptcha-response") String recaptcha, AccountsDTO dto)
			throws IOException {
		String secretKey = "6LdQQzsUAAAAADGIM74adZh7-6AZYUHGSlpZmdeP";
		VerifyRecaptcha.setSecretKey(secretKey);
		String gRecaptchaResponse = recaptcha;
		System.out.println(recaptcha + " recaptcha");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		String result = "fail";
		if (verify) {
			result = "success";
		}
		if (result == "fail") {
			return "/login/signup";
		}
		this.key = key();
		dto.setRandkey(this.key);
		accountsService.insert(dto);
		MailSend(dto.getId());
		return "redirect:/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.invalidate();
		return "redirect:/";
	}

	@Autowired
	private JavaMailSender mailSender;

	public void MailSend(String id) {
		try {
			String setfrom = "jisungyeah@gmail.com";
			String tomail = "jiwangood2@naver.com";
			String title = "haha";
			String content = "http://localhost:8090/emailCheck?id=" + id + "&key=" + this.key;
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			message.setTo(tomail); // 받는사람 이메일
			message.setSubject(title); // 메일제목은 생략이 가능하다
			message.setText(content); // 메일 내용

			mailSender.send(message);
			System.out.println("mail sent!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long key() {
		String num="";
		for (int i = 0; i < 10; i++) {
			num += Integer.toString(new Random().nextInt(10));
		}
		System.out.println(" generated key" + num);
		return Long.parseLong(num);
	}

	@RequestMapping(value = "/emailCheck")
	public String haha(@RequestParam("key") int key, String id) {
		long randKey = accountsService.randkey(id);
		if (randKey == key) {
			accountsService.updateRandkey(id);
		}
		return "/";
	}

}
