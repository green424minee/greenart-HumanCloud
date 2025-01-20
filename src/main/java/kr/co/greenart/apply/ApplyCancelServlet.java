package kr.co.greenart.apply;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HumanCloud/Recruitment/apply/cancel")
public class ApplyCancelServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplyingService service = ApplyingService.getInstance();
		String apply_id = req.getParameter("apply_id");
		int id = Integer.parseInt(apply_id);
		
		service.deleteApply(id);
		resp.sendRedirect(req.getContextPath() + "/HumanCloud/user/MyPage/apply");
	}
}
