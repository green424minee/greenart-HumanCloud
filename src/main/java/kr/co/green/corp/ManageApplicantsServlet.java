package kr.co.green.corp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//지원자 조회 


@WebServlet("/HumanCloud/corp/ManageApplicantsServlet")
public class ManageApplicantsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/corp_views/manageApplicants.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String jobId = request.getParameter("jobId");
        
        // 지원자 조회 로직 구현
        // 데이터베이스에서 선택된 공고에 대한 지원자 목록을 가져오는 코드 작성
        
        // 지원자 목록을 request에 저장
        // request.setAttribute("applicantList", applicantList);
        
        // 결과를 JSP로 포워딩
//        request.getRequestDispatcher("manageApplicants.jsp").forward(request, response);
    }
}
