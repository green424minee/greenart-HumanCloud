package kr.co.greenart.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.util.ValidatorUtil;

@WebServlet("/HumanCloud/user/MyPage/update")
public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user_view/UserUpdatePage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserService service = UserService.getInstance();
		User user = (User) session.getAttribute("login");
		String currentPassword = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");
		String newPasswordCheck = req.getParameter("newPasswordCheck");
		
		if (!currentPassword.equals(user.getPassword())) {
			// TODO 현재 비밀번호 불일치
			
		} else if (!ValidatorUtil.isPasswordMatch(newPassword, newPasswordCheck)) {
			// TODO 비밀번호 확인 불일치
			
		} else {
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			
			User update = User.builder().userName(user.getUserName()).password(newPassword).phone(phone).email(email).address(address).build();
			service.updateUser(update);
			req.getRequestDispatcher("/WEB-INF/user_view/UserUpdateResult.jsp").forward(req, resp);
		}
	}
}
