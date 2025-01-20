package kr.co.greenart.resume;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.user.User;
import kr.co.greenart.user.UserService;

@WebServlet("/HumanCloud/user/MyPage/resume/my/setDefault")
public class SetDefaultResumeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("login");
		String userName = user.getUserName();
		String id = req.getParameter("id");
		int resume_id = Integer.parseInt(id);
		
		service.updateDefaultResume(userName, resume_id);
		resp.sendRedirect(req.getContextPath() + "/HumanCloud/user/MyPage/resume");
	}
}
