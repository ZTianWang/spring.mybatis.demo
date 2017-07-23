package com.gwang.spring.mybatis.demo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwang.spring.mybatis.demo.test.po.User;

@Controller
public class RespBodyController {

	@RequestMapping(value="/findById")
	@ResponseBody
	/*这里使用了jackson将数据转换为json数据*/
	public User findById(@RequestParam("id")Integer id){
		User user = new User();
		user.setId(id);
		user.setName("蜗牛");
		user.setAge(21);
		user.setCity("太原");
		return user;
	}
}
