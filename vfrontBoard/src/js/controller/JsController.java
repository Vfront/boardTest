package js.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.dto.JsBoardDTO;
import js.service.JsService;

public class JsController {
	
	private JsService service;

	public String master(HttpServletRequest request, HttpServletResponse response, String works) {
		
		if(service == null){
			service = new JsService();
		}
		
		System.out.println(works);
		String nextUrl = null;
		if(works.equals("/showList")){
			List<JsBoardDTO> boardList = service.showList();
			request.setAttribute("boardList", boardList);
			nextUrl = "/WEB-INF/js/showList.jsp";
		}
		
		return nextUrl;
	}

}
