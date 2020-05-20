package practice1.controller;

import javax.servlet.http.*;

public class PMainController implements PClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main.jsp";
		return view;
	}

}
