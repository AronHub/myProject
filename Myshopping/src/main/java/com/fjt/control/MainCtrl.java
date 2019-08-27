package com.fjt.control;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.fjt.util.Md5Tool;

/**
 * 主页控制器
 * @author pc
 *
 */
@Controller
public class MainCtrl {
	private Logger logger = LoggerFactory.getLogger(MainCtrl.class);

	//直接这样就可以获取ServletContext
	@Autowired
	private ServletContext servletContext;

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
	public ModelAndView showMinView(HttpServletRequest request,
			HttpServletResponse response) {

		String view = "index";
		ModelAndView modelAndView = new ModelAndView(view);
		// 准备图书信息
		List<Book> bookList = bookService.findAll();
		//把显示的数据放在request中，因为request对象的生命周期短。
		request.setAttribute("bookList", bookList);

		try {
			//准备好用户上次登录时间
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String time = simpleDateFormat.format(date);
			Cookie[] ck = request.getCookies();
			boolean flag = false;
			if (ck != null) {
				for (Cookie cookie : ck) {
					if (cookie.getName().equals("lastTime")) {
						request.getSession().setAttribute("time",
								cookie.getValue());
						cookie.setValue(
								URLEncoder.encode("上次登录时间:", "utf-8") + time);
						cookie.setMaxAge(3600 * 24 * 2 * 7);
						response.addCookie(cookie);
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				//第一次登录
				Cookie cookie = new Cookie("lastTime",
						URLEncoder.encode("上次登录时间:", "utf-8") + time);
				cookie.setMaxAge(3600 * 24 * 2 * 7);
				response.addCookie(cookie);
				HttpSession session = request.getSession();
				session.setAttribute("time", "欢迎你第一次登录");
				//把jsesseionid存放在cookie中，实现浏览器关闭还能访问之前的session
				Cookie SessionCookie = new Cookie("JSESSIONID",
						session.getId());
				SessionCookie.setMaxAge(3600 * 24 * 2 * 7);//存放30min
				response.addCookie(SessionCookie);

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("登录出错!", e.getMessage());
		}

		return modelAndView;
	}

	/**
	 * 
	     * @Title: 安全退出
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @author fujiantao
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("safeExit")
	public ModelAndView safeExit(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();//使session无效
		String view = "loginView";
		ModelAndView model = new ModelAndView(view);
		return model;

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
		//密码用md5加密
		passwd = Md5Tool.MD5(passwd);
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

		//获取最近浏览的宝贝
		List<Book> list = (List<Book>) request.getSession()
				.getAttribute("lastBook");
		boolean flag = false;
		if (list != null) {
			for (Book bk : list) {
				if (bk.getName().equals(book.getName())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				list.add(book);
				request.getSession().setAttribute("lastBook", list);
			}

		} else {

			List<Book> bkList = new ArrayList<Book>();
			bkList.add(book);
			request.getSession().setAttribute("lastBook", bkList);
		}
		request.setAttribute("bookInfo", book);
		String view = "showDetail";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

}
