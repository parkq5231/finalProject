package com.company.temp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// user
	@RequestMapping("/user/user")
	public String user() {
		return "user/user";
	}

	// admin
	@RequestMapping("/admin/admin")
	public String admin() {
		return "admin/admin";
	}

	// top
	@RequestMapping("/top")
	public String top() {
		return "top";
	}

	// 로그인 페이지
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "user/login";
	}
}
