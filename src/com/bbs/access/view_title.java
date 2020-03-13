package com.bbs.access;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.userPlate;
import com.bbs.service.plateService;

/**
 * Servlet implementation class view_title
 */
@WebServlet("/view_title")
public class view_title extends HttpServlet {
	private static final long serialVersionUID = 1L;
private  plateService plateService=new plateService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取所有分类信息
		ArrayList<userPlate> arr = plateService.listMessage();
		// 把得到的列表放入request
		request.setAttribute("categories", arr);
		// 跳转
		request.getRequestDispatcher("plate.jsp").forward(request, response);
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
