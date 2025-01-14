package ko.co.green.recruitment;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.green.corp.Corp;
import kr.co.green.corp.CorpService;

@WebServlet("/HumanCloud/Recruitment")
public class RecruitmentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService service = RecruitmentService.getInstance();
		CorpService corpService = CorpService.getInstance();
		int recruitmentId = Integer.parseInt(req.getParameter("recruitment_id"));
		
		Recruitment recruitment  = service.selectById(recruitmentId);
		Corp corp =  corpService.selectByIdNo(recruitment.getCompany_id());
		req.setAttribute("recruitment", recruitment);
		req.setAttribute("corp", corp);
		req.getRequestDispatcher("/WEB-INF/Recruitment_view/recruitment.jsp").forward(req, resp);
	}
}
