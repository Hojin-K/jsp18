package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeDetailController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=====< NoticeDetailController IN >=====");
		String seq=request.getParameter("c");
		String hit=request.getParameter("h");
		NoticeDao dao=new NoticeDao();
		
		if(hit != null) {
			dao.hitupdate(seq);
		}
		
		Notice n=dao.getNotice(seq);
		
		System.out.println("=====< NoticeDetailController OUT >=====");
		request.setAttribute("n", n);
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
		
	}

}
