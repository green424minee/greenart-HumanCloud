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
		List<Recruitment> list = service.getRecruitment(corp.getId());
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobs.jsp")
			.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

