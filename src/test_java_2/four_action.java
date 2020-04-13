//package test_java_2;
//
//public class four_action {
//
//}

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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class four_action extends HttpServlet{ 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("UTF-8"); 
        request.setCharacterEncoding("UTF-8");
        Logger log= Logger.getLogger(four_action.class.getName()); 
        PropertyConfigurator.configure("log.properties");

        // 자바스크립트에서 JSON 으로 보낸 값 사용방법 모름
         
//		String currentPage = request.getParameter("currentPage"); 
//		String countPerPage = request.getParameter("countPerPage");
//		String keyword = request.getParameter("keyword"); 
        
        
        String currentPage = "1";
		String countPerPage = "1";
		String keyword = "강서구7길"; 
		
        String formData = request.getParameter("formData");
         
		System.out.println("currentPage >> "+ currentPage +"\n");  

		System.out.println("====formData >> "+ formData +"\n\n\n\n"); 
		
		String confmKey  = "U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=";
		String resultType = "json";
		
		log.debug("currentPage >>"+currentPage);
		 
//		String api_url = "http://www.juso.go.kr/addrlink/asddrLinkApi.do?currentPage="+currentPage
//				+"&countPerPage="+countPerPage+"&keyword="+keyword+
//				"&confmKey="+confmKey+"&resultType="+resultType;
		
		String api_url = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage=1&countPerPage=1&keyword=강서구7길&confmKey=U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=&resultType=json";
		
		
		URL url = new URL(api_url);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringBuffer sb = new StringBuffer();
		String tempStr = null;
		 
		int i =1;
		while(true) {
			
			tempStr= br.readLine();

			sb.append(tempStr);
			if (tempStr== null)
				break; 
			 
			System.out.println(i+"sb >> "+sb);
			i+=1;
		}

		
		br.close();
		bw.close(); 
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString()); 
		 
	}
	
	
}