package kr.co.greenart.apply;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.greenart.resume.Resume;
import kr.co.greenart.resume.ResumeService;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/Recruitment/apply")
public class ApplyingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService recruitService = RecruitmentService.getInstance();
		ResumeService resumeService = ResumeService.getInstance();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("login");
		List<Resume> list = resumeService.selectMyResumeList(user.getId());
		
		String recruitmentId = req.getParameter("recruitment_id");
		int recruitment_id = Integer.parseInt(recruitmentId);
		Recruitment recruitment = recruitService.selectById(recruitment_id);
		
		req.setAttribute("recruitment", recruitment);
		req.setAttribute("resumeList", list);
		req.getRequestDispatcher("/WEB-INF/applying_view/apply.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplyingService service = ApplyingService.getInstance();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("login");
		
		String myresume_id = req.getParameter("resume");
		int resume_id = Integer.parseInt(myresume_id);
		String recruitmentId = req.getParameter("recruitment_id");
		int recruitment_id = Integer.parseInt(recruitmentId);
		
		Apply apply = Apply.builder()
					.recruitment_id(recruitment_id)
					.user_id(user.getId())
					.resume_id(resume_id)
					.build();
		
		service.insertApplyment(apply);
		req.getRequestDispatcher("/WEB-INF/applying_view/ApplyResult.jsp").forward(req, resp);
	}
}
