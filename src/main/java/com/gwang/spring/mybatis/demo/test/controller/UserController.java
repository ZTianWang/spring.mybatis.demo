package com.gwang.spring.mybatis.demo.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gwang.spring.mybatis.demo.test.po.User;

@Controller
/*url请求定位*/
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/add")
	/*通过po包装传递参数*/
	public void add(User user) {
		System.out.println("add....");
		System.out.println(user.getName()+" "+user.getAge()+" "+user.getCity());
	}

	@RequestMapping("/login")
	/*网页传递的参数做形参
	 * @RequestParam:方法参数动态注入；若没有则参数名与表单参数必须一致
	 * 参数可加入session
	 * ModelMap:可将参数加入request作用域*/
	public String login(@RequestParam("n")String uname,@RequestParam("p")String upwd,ModelMap model,HttpSession session) {
		System.out.println("login:"+uname+"-"+upwd);
//		req.setAttribute("uname", uname);
		model.put("uname", uname);
		session.setAttribute("uname", uname);
		
		/*forward:请求转发，页面跳转;redirect:重定向*/
//		return "forward:/welcome.jsp";
//		return "redirect:www.baidu.com";
		
		/*若返回值无forward或redirect则调用视图解析器*/
		return "welcome";
	}
	
	/*使用ModelAndView模型视图类
	 * 不推荐*/
	@RequestMapping("/mv-login")
	public ModelAndView login(@RequestParam("n")String uname,@RequestParam("p")String upwd) {
		ModelAndView mv = new ModelAndView();
		/*view为要跳转的页面路径*/
		mv.setViewName("welcome");
		/*跳转时的参数*/
		mv.getModelMap().put("uname", uname);
		return mv;
	}
	
	@RequestMapping("/{id}/del")
	/*@PathVariable:url中的参数动态注入
	 * RESTful风格*/
	public void del(@PathVariable("id")Integer id) {
		System.out.println("del...."+id);
	}

}
