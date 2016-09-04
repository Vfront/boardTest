package js.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsController {

	public String master(HttpServletRequest request, HttpServletResponse response, String works) {
		
		System.out.println(works);
		String nextUrl = null;
		if(works.equals("/showList")){
			nextUrl = "/WEB-INF/js/showList.jsp";
		}
		return nextUrl;
	}

}
