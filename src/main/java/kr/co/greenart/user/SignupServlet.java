package kr.co.greenart.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.greenart.util.ValidatorUtil;

@WebServlet("/HumanCloud/user/Signup")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user_view/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		String name = req.getParameter("name");
		String userId = req.getParameter("userid");
		String password =  req.getParameter("password");
		String passwordCheck = req.getParameter("passwordCheck");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		if(ValidatorUtil.isPasswordMatch(password, passwordCheck)) {
			User user = User.builder().name(name).userId(userId).password(password).phone(phone).email(email).build();
			service.insertUser(user);
			req.getRequestDispatcher("/WEB-INF/user_view/signupResult.jsp").forward(req, resp);
		} else {
			req.setAttribute("error", "문제발생");
			req.getRequestDispatcher("/WEB-INF/user_view/signup.jsp").forward(req, resp);
		}
	}
}
