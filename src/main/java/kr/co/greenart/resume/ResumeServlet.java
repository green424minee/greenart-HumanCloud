package kr.co.greenart.resume;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/user/MyPage/resume/my")
public class ResumeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResumeService service = ResumeService.getInstance();
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		int resume_id = Integer.parseInt(id);
		
		Resume resume = service.selectMyResume(resume_id);

		int user_id = resume.getUser_id();
		User user = (User) session.getAttribute("login");
		if (user_id == user.getId()) {
//			Education
//			Experience
//			License
			req.setAttribute("resume", resume);
			req.getRequestDispatcher("/WEB-INF/user_view/resume/resume.jsp").forward(req, resp);
		} else {
			// 이력서의 유저아이디와 로그인계정의 아이디가 일치하지 않으면 잘못된 접근
			resp.sendError(400, "Invalid action");
		}
	}
}
