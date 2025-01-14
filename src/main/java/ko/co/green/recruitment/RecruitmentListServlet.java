package ko.co.green.recruitment;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.green.corp.Corp;
import kr.co.green.corp.CorpService;

@WebServlet("/HumanCloud/RecruitmentList")
public class RecruitmentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService service = RecruitmentService.getInstance();
		List<RecruitmentList> list = service.selectAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/Recruitment_view/RecruitmentList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService service = RecruitmentService.getInstance();
		String region = "%" + req.getParameter("region") + "%";
		String industry = "%" + req.getParameter("industry") + "%";
		String keyword = "%" + req.getParameter("keyword") + "%";
		
		List<RecruitmentList> list = service.selectByCondition(region, industry, keyword);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/Recruitment_view/RecruitmentList.jsp").forward(req, resp);
	}
}
