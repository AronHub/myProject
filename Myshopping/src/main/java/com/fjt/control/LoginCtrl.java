package com.fjt.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Book;
import com.fjt.service.BookService;
import com.fjt.service.MyCart;
import com.fjt.service.UserService;

@Controller
public class LoginCtrl {
	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	// 跳转登录界面
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		String view = "loginView";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

	// 登录校验
	@RequestMapping("/checkUser")
	public ModelAndView checkUser(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		boolean flag = userService.findUser(userName, passwd);
		String view = "";
		ModelAndView modelAndView = new ModelAndView();

		if (flag) {
			//创建购物车，并且存放到session
			MyCart cart = new MyCart();
			request.getSession().setAttribute("myCart", cart);

			// 用户存在，跳转到购物大厅(主页)
			view = "index";
			modelAndView.setViewName(view);
			// 准备图书信息
			List<Book> bookList = bookService.findAll();
			//把显示的数据放在request中，因为request对象的生命周期短。
			request.setAttribute("bookList", bookList);
			return modelAndView;
		}
		// 用户不存在，返回登录页面
		view = "loginView";
		modelAndView.setViewName(view);

		return modelAndView;
	}

}
