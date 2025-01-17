package kr.co.greenart.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HumanCloud/user/Signin")
public class SigninServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user_view/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		User user = service.selectById(userName);
		if (user == null) {
			req.setAttribute("message", "해당 id는 존재하지 않습니다. id를 확인해주세요.");
			req.getRequestDispatcher("/WEB-INF/user_view/signin.jsp").forward(req, resp);
		} else if (!password.equals(user.getPassword())) {
			req.setAttribute("message", "비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요.");
			req.getRequestDispatcher("/WEB-INF/user_view/signin.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("login", user);
			resp.sendRedirect("/_greenart_HumanCloud");
		}
	}
}
