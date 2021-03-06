package com.gwang.spring.mybatis.demo.controller.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwang.spring.mybatis.demo.domain.Account;
import com.gwang.spring.mybatis.demo.service.AccountService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/registerPage")
	public String registerPage () {
		return "account/register";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Map<String, Object> register (String username, String password) {
		ModelMap model = new ModelMap();
		try {
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
			account.setValid(1);
			accountService.createAccount(account);
			return model.addAttribute("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			return model.addAttribute("success", false);
		}
	}
}
