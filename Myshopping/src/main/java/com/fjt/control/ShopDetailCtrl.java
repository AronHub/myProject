package com.fjt.control;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Book;
import com.fjt.service.BookService;
import com.fjt.service.MyCart;

import net.sf.json.JSONArray;

//购物车详细控制器
@Controller
public class ShopDetailCtrl {
	private Logger logger = LoggerFactory.getLogger(MainCtrl.class);

	@Autowired
	private BookService bookService;

	/**
	 * 
	     * @Title: 添加到购物车
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/addshopping")
	public ModelAndView addshopping(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		Long bookID = Long.parseLong(bookId);
		Book book = bookService.findById(bookID);
		//取出购物车
		MyCart cart = (MyCart) request.getSession().getAttribute("myCart");
		if (cart != null) {
			cart.addBook(bookId, book);
			//为了防止某个页面刷新，我们可以使用redirect重定向到另外一个控制器。
			//这样实现可以让浏览器url上的参数不见。如下，可以让?BookId=1不见。
			//（http://localhost:8080/Myshopping/showBookDetail?BookId=1）
			String view = "redirect:getMyCart";
			ModelAndView model = new ModelAndView(view);
			return model;
		}
		String view = "loginView";
		ModelAndView model = new ModelAndView(view);
		return model;
	}

	/**
	 *     购物车删除
	     * @Title: MyCartDelet
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @return String 返回类型
	     * @throws
	 */
	@RequestMapping("/MyCartDelet")
	public String MyCartDelet(HttpServletRequest request) {
		String id = request.getParameter("id");
		MyCart mycart = (MyCart) request.getSession().getAttribute("myCart");
		mycart.deltBook(id);
		//跳转到购物车界面
		return "forward:/getMyCart";
	}

	/**
	 * 
	     * @Title: 删除所有
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @return String 返回类型
	     * @throws
	 */
	@RequestMapping("/MyCartDeletAll")
	@ResponseBody
	public String MyCartDeletAll(HttpServletRequest request) {
		try {
			MyCart myCart = (MyCart) request.getSession()
					.getAttribute("myCart");
			myCart.clearBook();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除所有失败!", e.getMessage());
			return "error";
		}

		return "success";
	}

	/**
	 * 
	     * @Title: 删除所有后，重新获取购物车数据
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/getMyCart")
	public ModelAndView getMyCart(HttpServletRequest request) {
		//取出购物车
		MyCart cart = (MyCart) request.getSession().getAttribute("myCart");
		String view = "cartInfo";
		ModelAndView model = new ModelAndView(view);
		//准备当前用户的购物车内容
		request.setAttribute("shoppInfo", cart.showAllMyCart());
		//返回购物车的总价
		request.setAttribute("totalPrice", cart.getTotalPrice());
		return model;

	}

	/**
	 * 更新
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatMyCart")
	@ResponseBody
	public String updatMyCart(HttpServletRequest request) {
		String acount = request.getParameter("acounts");
		String bookIds = request.getParameter("bookIds");

		try {
			JSONArray ArrayAcount = JSONArray.fromObject(acount);
			JSONArray ArrayId = JSONArray.fromObject(bookIds);
			MyCart myCart = (MyCart) request.getSession()
					.getAttribute("myCart");

			for (int i = 0; i < ArrayAcount.size(); i++) {
				myCart.updateBook(ArrayId.getString(i),
						ArrayAcount.getString(i));
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("更新出错!", e.getMessage());
			return "error";
		}

		return "success";

	}

}
