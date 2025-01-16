package kr.co.greenart.resume;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/user/MyPage/resume/create")
public class ResumeCreateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("login");
		int user_id = user.getId();
		
		service.createMyResume(user_id);
		int resume_id = service.getGeneratedKey();
		service.createEducation(resume_id);
		service.createExperience(resume_id);
		
		resp.sendRedirect(req.getContextPath()+"/HumanCloud/user/MyPage/resume");
	}
}
