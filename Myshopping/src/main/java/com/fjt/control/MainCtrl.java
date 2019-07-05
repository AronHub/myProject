package com.fjt.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainCtrl {

	/**
	 * 
	     * @Title: showMinView
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("/")
	public ModelAndView showMinView() {
		String view = "index";
		ModelAndView modelAndView = new ModelAndView(view);
		return modelAndView;
	}
}
