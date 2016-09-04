package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.controller.JsController;

public class FrontController extends HttpServlet{
	
	
	private JsController jsController;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		master(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		master(req, resp);
	}
	

	protected void master(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String serv = request.getServletPath();
		String pack = request.getContextPath();
		
		String works = uri.replaceAll(pack+serv+"/", "");
		
		String type = works.substring(0,works.lastIndexOf("/"));
		works = works.substring(works.lastIndexOf("/"));		
				
		System.out.println("TYPE = " + type);
		System.out.println("WORKS = " + works);
		
		String nextUrl = "";
		
		/*
		 * 
		 * 본인 if-else 구역에 
		 * 본인 컨트롤러 로 이동하는 구문 써넣으시면 되겠습니다 
		 * 
		 * 그 뒤 알아서 작업!!!
		 */
		
		if(type.equals("js")){ //중서
			if(jsController == null){
				jsController = new JsController();
			}
			
			nextUrl = jsController.master(request, response, works);
		}else if(type.equals("jh")){ //요한
			
		}else if(type.equals("dh")){ //도형
			
		}else if(type.equals("sy")){ //선영
			
		}else if(type.equals("sh")){ //선하
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
		
	}
	
}
