//package api_2;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.URL;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class four_action extends HttpServlet{ 
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 
//        response.setCharacterEncoding("UTF-8"); 
//        request.setCharacterEncoding("UTF-8");
//
//
//        // 자바스크립트에서 JSON 으로 보낸 값 사용방법 모름
//        
//        
//		String currentPage = request.getParameter("currentPage");
//		String countPerPage = request.getParameter("countPerPage");
//		String keyword = request.getParameter("keyword"); 
//
//		String confmKey  = "U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=";
//		String resultType = "json";
//		
//		 
//		String api_url = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage
//				+"&countPerPage="+countPerPage+"&keyword="+keyword+
//				"&confmKey="+confmKey+"&resultType="+resultType;
//		
//		URL url = new URL(api_url);
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
//		StringBuffer sb = new StringBuffer();
//		String tempStr = null;
//		
//		
//
//		while(true) {
//			
//			tempStr= br.readLine();
//
//			sb.append(tempStr);
//			if (tempStr== null)
//				break; 
//			
//			System.out.println("sb >> "+sb);
//		}
//
//		
//		br.close();
//		bw.close();
//		
//		request.setAttribute("api_data", sb.toString());
//		 
//	}
//	
//	
//}


package api_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class four_action extends HttpServlet{ 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        response.setCharacterEncoding("UTF-8"); 
        request.setCharacterEncoding("UTF-8");


        // 자바스크립트에서 JSON 으로 보낸 값 사용방법 모름
        
        
		String currentPage = request.getParameter("currentPage");
		String countPerPage = request.getParameter("countPerPage");
		String keyword = request.getParameter("keyword"); 

		String confmKey  = "U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=";
		String resultType = "json";
		
		 
		String api_url = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage
				+"&countPerPage="+countPerPage+"&keyword="+keyword+
				"&confmKey="+confmKey+"&resultType="+resultType;
		
		URL url = new URL(api_url);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringBuffer sb = new StringBuffer();
		String tempStr = null;
		
		

		while(true) {
			
			tempStr= br.readLine();

			sb.append(tempStr);
			if (tempStr== null)
				break; 
			
			System.out.println("sb >> "+sb);
		}

		
		br.close();
		bw.close();
		
		request.setAttribute("api_data", sb.toString());
		 
	}
	
	
}