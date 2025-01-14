package kr.co.green.corp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//공고 관리

@WebServlet("/HumanCloud/corp/ManageJobsServlet")
public class ManageJobsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/corp_views/manageJobs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String jobTitle = request.getParameter("jobTitle");
//        String jobDescription = request.getParameter("jobDescription");
        
        // 공고 등록 로직 구현
        // 데이터베이스에 공고 정보를 저장하는 코드 작성
        
        // 공고 목록을 가져오는 로직 구현
        // 데이터베이스에서 공고 목록을 가져오는 코드 작성
        
        // 공고 목록을 request에 저장
        // request.setAttribute("jobList", jobList);
        
        // 결과를 JSP로 포워딩
//        request.getRequestDispatcher("manageJobs.jsp").forward(request, response);
    }
}
