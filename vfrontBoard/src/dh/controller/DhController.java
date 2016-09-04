package dh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DhController {

	public String master(HttpServletRequest request, HttpServletResponse response, String works) {
		
		System.out.println("dhcontroller  works : " + works);
		String nextUrl = null;
		
		
		if(works.equals("/showList")){
			
			nextUrl = "/WEB-INF/dh/mainList.jsp";
		}
		return nextUrl;
	}
}
