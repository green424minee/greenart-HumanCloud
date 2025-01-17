package kr.co.greenart.apply;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/user/MyPage/apply")
public class ApplyListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplyingService applyService = ApplyingService.getInstance();
		RecruitmentService recruitService = RecruitmentService.getInstance();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("login");
		
		List<Apply> list = applyService.selectAll(user.getId());
		List<Recruitment> applyList = new ArrayList<>();
		for (Apply a : list) {
			applyList.add(recruitService.selectById(a.getRecruitment_id()));
		}
		req.setAttribute("list", list);
		req.setAttribute("applyList", applyList);
		req.getRequestDispatcher("/WEB-INF/applying_view/applyList.jsp").forward(req, resp);
	}
}
