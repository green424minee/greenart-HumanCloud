package kr.co.greenart.resume;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HumanCloud/user/MyPage/resume/my/delete")
public class ResumeDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		
		String id = req.getParameter("id");
		int resume_id = Integer.parseInt(id);
		
		service.deleteLicenses(resume_id);
		service.deleteExperience(resume_id);
		service.deleteEducation(resume_id);
		service.deleteResume(resume_id);
		
		resp.sendRedirect(req.getContextPath()+"/HumanCloud/user/MyPage/resume");
	}
}
