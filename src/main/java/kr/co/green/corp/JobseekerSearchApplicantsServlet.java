package kr.co.green.corp;
//구직자 검색
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HumanCloud/corp/SearchApplicantsServlet")
public class JobseekerSearchApplicantsServlet extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/corp_views/jobseekerSearchApplicants.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");
        
        // 검색 로직 구현
        // 데이터베이스에서 검색 결과를 가져오는 코드 작성
        
        // 검색 결과를 request에 저장
        // request.setAttribute("searchResults", searchResults);
        
        // 결과를 JSP로 포워딩
        request.getRequestDispatcher("searchApplicants.jsp").forward(request, response);
    }
}
