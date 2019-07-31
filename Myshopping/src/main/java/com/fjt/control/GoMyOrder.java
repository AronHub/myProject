package com.fjt.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Users;
import com.fjt.service.MyCart;
import com.fjt.service.OrderService;
import com.fjt.util.SendMailToSomeone;

/**
 * 订单确认控制器
 * @author pc
 *
 */
@Controller
public class GoMyOrder {

	@Autowired
	private OrderService orderService;

	/**
	 * 
	 * 跳转到我的订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/goMyOrderView")
	public ModelAndView goMyOrderView(HttpServletRequest request) {
		MyCart mycart = (MyCart) request.getSession().getAttribute("myCart");
		String view = "orderSure";
		ModelAndView modelAndView = new ModelAndView(view);
		request.setAttribute("mycart", mycart.showAllMyCart());
		request.setAttribute("totalPrice", mycart.getTotalPrice());
		return modelAndView;
	}

	/**
	 * 提交订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/goOrdreFinish")
	public ModelAndView goOrdreFinish(HttpServletRequest request) {
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
		Users user = (Users) request.getSession().getAttribute("loginUser");
		orderService.saveOrder(myCart, user);

		//发送邮件，要有网络才可以。
		SendMailToSomeone smts = new SendMailToSomeone();
		smts.send("邮件发送测试", "hello words!", "416926039@qq.com",
				"ping-han@sohu.com", "smtp.sohu.com");

		String view = "OrderFinish";
		ModelAndView modelAndView = new ModelAndView(view);
		return modelAndView;

	}

}
