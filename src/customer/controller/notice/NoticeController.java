package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeController implements Controller{
	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("=====< NoticeController IN >=====");
		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if(field==null || field.equals(""))
			field="title";
		
		String query=request.getParameter("q");
		System.out.println("query : "+query);
		if(query==null)
			query="";
		
		NoticeDao dao=new NoticeDao();
		List<Notice> list= dao.noticeSelAll(field,query);
		
		request.setAttribute("list", list); 
		request.setAttribute("query", query);
		request.getRequestDispatcher("notice.jsp").forward(request, response);
	}
}
