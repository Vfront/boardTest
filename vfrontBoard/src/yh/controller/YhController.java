package yh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yh.dao.BoardDAO;
import yh.dao.BoardDTO;

public class YhController {

	
	
	public String master(HttpServletRequest request, HttpServletResponse response, String works) {
		String nextUrl = null;


		if(works.equals("/myList")){
			int rownum = new BoardDAO().select();
			System.out.println(rownum);
			request.setAttribute("num", rownum);
			nextUrl = "/WEB-INF/yh/insertForm.jsp";
		}else if(works.equals("/insert")){
			BoardDTO dto = new BoardDTO(request.getParameter("title"), request.getParameter("content"));
			int res = new BoardDAO().insert(dto);
			if(res>0){
				System.out.println("성공");
				request.setAttribute("myList", new BoardDAO().showList());
				nextUrl = "/WEB-INF/yh/myList.jsp";
			}else{
				System.out.println("실패");
			}			
		}else if(works.equals("/showList")){
			request.setAttribute("myList", new BoardDAO().showList());
			nextUrl = "/WEB-INF/yh/myList.jsp";
		}
		return nextUrl;
		
		
	}



}
