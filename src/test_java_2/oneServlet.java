package test_java_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import test_java_2.oneServlet;

/**
 * Servlet implementation class twoServlet
 */
@WebServlet("/one_servlet")
public class oneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public oneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Logger log= Logger.getLogger(oneServlet.class.getName());
		
		
		String currentPage = request.getParameter("currentPage");
		String countPerPage = request.getParameter("currentPage");
		String keyword = request.getParameter("keyword"); 
		String confmKey  = "U01TX0FVVEgyMDIwMDMyNjAxNTMxNjEwOTU4NTc=";
		String resultType = "json";

		
		log.debug("currentPage >>" + currentPage);

		String json = request.getParameter("jsonData");
		
		
		String message= "seccuss";
		
		String api_url = "http://www.juso/go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage
				+"&countPerPage="+countPerPage+"&keyword="+keyword+
				"&confmKey="+confmKey+"&resultType="+resultType;
		
		URL url = new URL(api_url);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringBuffer sb = new StringBuffer();
		String tempStr = null;
		
		
		log.debug("api_url >>" + api_url);
		
		while(true) {
			
			tempStr= br.readLine();

			sb.append(tempStr);
			if (tempStr== null)
				break; 
			
			log.debug("sb >> "+sb);
		}
		
		String api_data = "";
		
		request.setAttribute("servlet_data", api_data);
		
		

//		String str_alert = "";
//		str_alert = "alert('"+ message +"');" ;
//		
//		out.println("<script>");
//		out.println(str_alert);
//		out.println("location='two.html';");
//		out.println("</script>");
		
		
		br.close();
		bw.close();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString());

	
	}
}
