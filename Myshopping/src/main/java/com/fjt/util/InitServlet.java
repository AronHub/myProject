package com.fjt.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fjt.control.MainCtrl;

/**
 * 保存网站计数工具
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(MainCtrl.class);

	/**
	 * 初始化
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		logger.info("开始初始化");
		//从recoder.txt文件中读取浏览量
		//1.首先得到该文件真实路径。
		//相对路径：指的是相对当前文件的路径。     绝对路径：从根目录开始的路径。比如从C：盘开始的路径
		ServletContext servletContext = this.getServletContext();
		String filePath = this.getServletContext()
				.getRealPath("File/recoder.txt");
		//2.打开文件
		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferReadr = new BufferedReader(fileReader);) {

			String nums = bufferReadr.readLine();
			//把nums添加到servletContext
			this.getServletConfig().getServletContext().setAttribute("nums",
					nums);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("网站计数器初始化出错!", e.getMessage());
		}

	}

	/**
	 * 销毁
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("initServlet destory 被调用...");
		//把servletContext值重新保存到文件
		//1.首先得到该文件真实路径。
		String filePath = this.getServletContext()
				.getRealPath("File/recoder.txt");
		//2.打开文件
		try (FileWriter fileWriter = new FileWriter(filePath);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter);) {

			String nums = (String) this.getServletContext()
					.getAttribute("nums");
			//重新写文件
			bufferWriter.write(nums);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("网站计数器销毁出错!", e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
