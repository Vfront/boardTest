package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dh.controller.DhController;
import js.controller.JsController;

public class FrontController extends HttpServlet{
	
	
	private JsController jsController;
	private static DhController dhController;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		master(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		master(req, resp);
	}
	

	protected void master(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println("req uri ="+ uri);
		String serv = request.getServletPath();
		System.out.println("serv = "+ serv);
		String pack = request.getContextPath();
		System.out.println("pack ="+ pack);
		String works = uri.replaceAll(pack+serv+"/", "");
		
		String type = works.substring(0,works.lastIndexOf("/"));
		works = works.substring(works.lastIndexOf("/"));		
				
		System.out.println("TYPE = " + type);
		System.out.println("WORKS = " + works);
		
		String nextUrl = "";
		
		
		if(type.equals("js")){ //以묒꽌
			if(jsController == null){
				jsController = new JsController();
			}
			System.out.println(request.getParameter("num"));
			nextUrl = jsController.master(request, response, works);
		}else if(type.equals("jh")){ //�슂�븳
			
		}else if(type.equals("dh")){ //�룄�삎
			System.out.println(">>>type dh comp");
			
			if(dhController == null){
				dhController = new DhController();
			}
			
			nextUrl = dhController.master(request,response,works);
			System.out.println("front cont :"+ nextUrl);
			
		}else if(type.equals("sy")){ //�꽑�쁺
			
		}else if(type.equals("sh")){ //�꽑�븯
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
		
	}
	
}
