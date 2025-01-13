package kr.co.greenart.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HumanCloud/user/MyPage")
public class UserMyPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			req.getRequestDispatcher("/WEB-INF/user_view/UserMyPage.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/_greenart_HumanCloud/HumanCloud/user/Signin");
		}
	}
}
