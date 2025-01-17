package ko.co.green.managejob;

import java.io.IOException;
import java.util.List;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.green.corp.Corp;

//공고 관리
@WebServlet("/HumanCloud/corp/ManageJobsServlet")
public class ManageJobsServlet extends HttpServlet {
	
	private RecruitmentService service = RecruitmentService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    Corp corp = (Corp) session.getAttribute("corp");
	    
	    String status = req.getParameter("status");
	    if (status == null) {
	        status = "active"; // 기본값 설정
	    }
	    
	    List<Recruitment> list = service.getRecruitmentByStatus(corp.getId(), status);
	    req.setAttribute("list", list);
	    req.setAttribute("currentStatus", status);
	    
	    req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobs.jsp")
	        .forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//공고 삭제
		HttpSession session = req.getSession();
	    Corp corp = (Corp) session.getAttribute("corp");
	    
	    int recruitmentId = Integer.parseInt(req.getParameter("recruitmentId"));
	    service.updateStatusToExpired(recruitmentId, corp.getId());
	    
	    // 처리 후 바로 ManageJobsServlet으로 리다이렉트
	    resp.sendRedirect("ManageJobsServlet?status=expired");
	}
	
}

