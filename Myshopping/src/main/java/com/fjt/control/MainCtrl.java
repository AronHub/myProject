package com.fjt.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Book;
import com.fjt.pojo.Users;
import com.fjt.service.BookService;
import com.fjt.service.MyCart;
import com.fjt.service.UserService;

/**
 * 主页控制器
 * @author pc
 *
 */
@Controller
public class MainCtrl {
	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	/**
	 * 
	     * @Title: 显示主页
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/")
	public ModelAndView showMinView(HttpServletRequest request) {
		String view = "index";
		ModelAndView modelAndView = new ModelAndView(view);
		// 准备图书信息
		List<Book> bookList = bookService.findAll();
		//把显示的数据放在request中，因为request对象的生命周期短。
		request.setAttribute("bookList", bookList);
		return modelAndView;
	}

	/**
	 * 
	     * @Title: 注册用户界面
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/register")
	public ModelAndView showRegeist(HttpServletRequest request) {
		String view = "register";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

	/**
	 * 
	     * @Title: 注册功能
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/userRegesit")
	@ResponseBody
	public String userRegesit(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		Users user = new Users();
		user.setEmail(email);
		user.setName(userName);
		user.setPasswd(passwd);
		user.setTel(tel);
		user.setGrade(1);
		userService.save(user);
		return "success";
	}

	/**
	 * 
	     * @Title: 显示我的购物车
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/showMyShop")
	public ModelAndView showMyShop(HttpServletRequest request) {
		MyCart cart = (MyCart) request.getSession().getAttribute("myCart");
		if (cart != null) {
			String view = "cartInfo";
			ModelAndView model = new ModelAndView(view);
			//准备当前用户的购物车内容
			request.setAttribute("shoppInfo", cart.showAllMyCart());
			//返回购物车的总价
			request.setAttribute("totalPrice", cart.getTotalPrice());
			return model;
		}
		String view = "loginView";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

	/**
	 * 
	     * @Title: 查看图书的详细信息
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/showBookDetail")
	public ModelAndView showBookDetail(HttpServletRequest request) {
		String bookId = request.getParameter("BookId");
		Long bookID = Long.parseLong(bookId);
		Book book = bookService.findById(bookID);
		request.setAttribute("bookInfo", book);
		String view = "showDetail";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

}
