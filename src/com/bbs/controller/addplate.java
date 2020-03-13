package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.service.UserService;
import com.bbs.service.plateService;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class addplate
 */
@WebServlet("/addplate")
public class addplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private plateService plateService= new   plateService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String plateTitle=request.getParameter("plateTitle");
		String  plateMessage=request.getParameter("plateMessage");
		
		if(StringUtils.isNullOrEmpty(plateTitle) ||StringUtils.isNullOrEmpty(plateMessage)
				|| plateTitle.trim().length()==0 || plateMessage.trim().length()==0) {
			request.setAttribute("error", "标题和内容不能为空");
			request.getRequestDispatcher("/view_title").forward(request, response);
			return;
		}
		plateTitle = plateTitle.trim();
		plateMessage=plateMessage.trim();
		// 判断分类在数据库中是否存在
		if(plateService.findTitleByName(plateTitle) != null) {
			request.setAttribute("error", "标题已经存在");
			request.getRequestDispatcher("/view_title").forward(request, response);
			return;
		}
		// 把分类添加到数据库
		plateService.addCategory(plateTitle,plateMessage);
		request.setAttribute("error", "标题添加成功");
		request.getRequestDispatcher("/view_title").forward(request, response);
		return;
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
