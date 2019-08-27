package com.fjt.control;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Book;
import com.fjt.pojo.Users;
import com.fjt.service.BookService;
import com.fjt.service.MyCart;
import com.fjt.service.UserService;
import com.fjt.util.Md5Tool;

/**
 * 
     * @ClassName: 登录控制器
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年7月31日
     *
 */
@Controller
public class LoginCtrl {

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	/**
	 * 
	     * @Title: 跳转登录界面
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @author fujiantao
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		String view = "loginView";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

	/**
	 * 
	     * @Title: 登录校验
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/checkUser")
	public String checkUser(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String checkCode = request.getParameter("checkCode");// 获取验证码
		HttpSession session1 = request.getSession();
		//验证验证码是否正确
		if (!session1.getAttribute("randCheckCode").equals(checkCode)) {
			//验证码不正确，返回登录界面
			return "forward:/login";
		}

		//密码加密之后去数据库判断
		passwd = Md5Tool.MD5(passwd);
		Users user = userService.findUser(userName, passwd);

		if (user != null) {

			//查看servletContext是否含有计数器值
			String number = (String) servletContext.getAttribute("nums");

			servletContext.setAttribute("nums",
					(Integer.parseInt(number) + 1) + "");

			//创建购物车，并且存放到session
			MyCart cart = new MyCart();

			//创建session,如果有则获取当前session，如果没有则创建一个新的session
			HttpSession session = request.getSession();
			//设置属性
			session.setAttribute("myCart", cart);

			//存放用户信息到session中
			request.getSession().setAttribute("loginUser", user);

			// 准备图书信息
			List<Book> bookList = bookService.findAll();
			//把显示的数据放在request中，因为request对象的生命周期短。
			request.setAttribute("bookList", bookList);

			// 用户存在，跳转到购物大厅(主页)
			return "redirect:/";
		}
		// 用户不存在，返回登录页面
		return "forward:/login";
	}

}
