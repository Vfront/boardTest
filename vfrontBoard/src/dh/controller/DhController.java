package dh.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DhController {

    private DhService service;
    private ArrayList<DhBoardBean>boardList;
    
    public DhController(){
    	service = new DhService();
    }
	
	public String master(HttpServletRequest request, HttpServletResponse response, String works) {

		System.out.println("dhcontroller  works : " + works);
		String nextUrl = null;
		
		if(works.equals("/showList")){
			ArrayList<DhBoardBean>boardList = service.summaryList();
			request.setAttribute("boardList", boardList);
			nextUrl = "/WEB-INF/dh/mainList.jsp";
		
		}//listpage �����ֱ�(home)
		
		return nextUrl;
	}
}
