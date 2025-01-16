package kr.co.greenart.resume;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HumanCloud/user/MyPage/resume/my/deleteLicense")
public class LicenseDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		String licenseId = req.getParameter("license_id");
		int license_id = Integer.parseInt(licenseId);
		service.deleteLicense(license_id);
		
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
}
