package kr.co.greenart.resume;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/user/MyPage/resume/my/update")
public class ResumeUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		String id = req.getParameter("id");
		int resume_id = Integer.parseInt(id);
		
		Resume resume = service.selectMyResume(resume_id);
		Education education = service.selectEducation(resume_id);
		Experience experience = service.selectExperience(resume_id);
		List<License> licenses = service.selectLicense(resume_id);
		req.setAttribute("education", education);
		req.setAttribute("experience", experience);
		req.setAttribute("licenses", licenses);
		req.setAttribute("resume", resume);
		req.getRequestDispatcher("/WEB-INF/user_view/resume/resumeUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		
		String id = req.getParameter("resume_id");
		int resume_id = Integer.parseInt(id);
		String title = req.getParameter("title");
		String school_type = req.getParameter("school_type");
		String school_name = req.getParameter("school_name");
		String schoolStatus = req.getParameter("schoolStatus");
		String adm = req.getParameter("adm_at");
		LocalDate adm_at = LocalDate.parse(adm);
		String grad = req.getParameter("grad_at");
		LocalDate grad_at = LocalDate.parse(grad);
		String job_title = req.getParameter("job_title");
		String dept = req.getParameter("dept");
		String position = req.getParameter("position");
		String prev_role = req.getParameter("prev_role");
		String companyStatus = req.getParameter("companyStatus");
		String join = req.getParameter("join_at");
		LocalDate join_at = LocalDate.parse(join);
		String leave_or_ongoing = req.getParameter("leave_or_ongoing_at");
		LocalDate leave_or_ongoing_at = LocalDate.parse(leave_or_ongoing);
		String value = req.getParameter("value");
		String issued = req.getParameter("issued_at");
		LocalDate issued_at = LocalDate.parse(issued);
		
		service.updateResume(resume_id, title);
		service.updateEducation(Education.builder()
								.resume_id(resume_id)
								.school_type(school_type)
								.school_name(school_name)
								.status(schoolStatus)
								.adm_at(adm_at)
								.grad_at(grad_at)
								.build());
		service.updateExperience(Experience.builder()
								.resume_id(resume_id)
								.job_title(job_title)
								.dept(dept)
								.position(position)
								.prev_role(prev_role)
								.status(companyStatus)
								.join_at(join_at)
								.leave_or_ongoing_at(leave_or_ongoing_at)
								.build());
		service.insertLicense(License.builder()
							.resume_id(resume_id)
							.value(value)
							.issued_at(issued_at)
							.build());
		
		Resume resume = service.selectMyResume(resume_id);
		Education education = service.selectEducation(resume_id);
		Experience experience = service.selectExperience(resume_id);
		List<License> licenses = service.selectLicense(resume_id);
		req.setAttribute("education", education);
		req.setAttribute("experience", experience);
		req.setAttribute("licenses", licenses);
		req.setAttribute("resume", resume);
		req.getRequestDispatcher("/WEB-INF/user_view/resume/resume.jsp").forward(req, resp);
	}
}
