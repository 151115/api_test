package test_java_2;

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


@WebServlet("/four_action")
public class four_action extends HttpServlet{ 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        response.setCharacterEncoding("UTF-8"); 
        request.setCharacterEncoding("UTF-8");
        

		String currentPage = request.getParameter("currentPage");
		String countPerPage = request.getParameter("countPerPage");
		String keyword = request.getParameter("keyword"); 

		String confmKey  = "U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=";
		String resultType = "json";
		
		
		
		
		String api_url ="http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage=1&countPerPage=1&keyword=\"강서구7길\"\r\n" + 
		"&confmKey=U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=&resultType=json\r\n";
		
//		String api_url = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage
//				+"&countPerPage="+countPerPage+"&keyword="+keyword+
//				"&confmKey="+confmKey+"&resultType="+resultType;
//		
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
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/xml");
//		response.getWriter().write(sb.toString()); 
		
		
		request.setAttribute("api_data", sb.toString());
		//RequestDispatcher dispatcher = .getRequestDispatcher("/four.html"); 
		
	}
	
	
}
