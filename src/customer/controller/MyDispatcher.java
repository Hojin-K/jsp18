package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.notice.NoticeController;
import customer.controller.notice.NoticeDetailController;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("=====< 디스패처 진입 >=====");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath);
		System.out.println("com: "+com);
		
		Controller ctr = null;
		try {
			if(com.equals("/customer/notice.do")) {
				ctr = new NoticeController();
			}else if(com.equals("/customer/noticeDetail.do")) {
				ctr = new NoticeDetailController();
			}
			ctr.execute(request, response);
		} catch (Exception e) {
			
		}
	}
}
