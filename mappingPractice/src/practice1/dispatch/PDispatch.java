package practice1.dispatch;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import practice1.controller.PClsController;

import java.io.*;
import java.util.*;

@WebServlet("*.cls")
public class PDispatch extends HttpServlet {
	
	public HashMap<String, PClsController> map;
	
	public void init(ServletConfig config) throws ServletException {
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			String path = this.getClass().getResource("").getPath();
			fin = new FileInputStream(path + "../resource/cls.properties");
			prop.load(fin);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		map = new HashMap<String, PClsController>();
		Set keys = prop.keySet();
		ArrayList<String> list = new ArrayList<String>(keys);
		for(int i = 0; i < list.size(); i++) {
			String key = list.get(i);
			String sclass = (String) prop.get(key);
			try {
				Class tmp = Class.forName(sclass);
				PClsController cls = (PClsController) tmp.newInstance();
				map.put(key, cls);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String full = req.getRequestURI();
		String domain = req.getContextPath();
		String realPath = full.substring(domain.length());
		PClsController cls = map.get(realPath);
		req.setAttribute("isRedirect", false);
		String view = cls.exec(req, resp);
		boolean bool = (boolean) req.getAttribute("isRedirect");
		if(bool) {
			resp.sendRedirect(view);
		} else {
			try {
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.forward(req, resp);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}