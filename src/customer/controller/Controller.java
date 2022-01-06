package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러 인터페이스를 만들어서 통일해주기 위해
public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception;
}
