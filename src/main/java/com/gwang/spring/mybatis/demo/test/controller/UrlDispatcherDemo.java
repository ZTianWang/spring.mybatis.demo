package com.gwang.spring.mybatis.demo.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*其他url请求分发方式，不推荐*/
@Controller
@RequestMapping("demo")
public class UrlDispatcherDemo {

	/*类似servlet的请求分发;不推荐
	 * get请求定位到此方法*/
	@RequestMapping(method=RequestMethod.GET)
	public void doGet(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("get....");
	}
	
	/* post请求定位到此方法*/
	@RequestMapping(method=RequestMethod.POST)
	public void doPost(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("post....");
	}
	
	/*类似于struts1的分发方式
	 * url:http://localhost:8080/demo?method=struts1  */
	@RequestMapping(params="method=struts1")
	public void struts1() {
		System.out.println("struts1...");
	}
	
}
