package kr.co.greenart.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.green.corp.Corp;
import kr.co.green.corp.CorpService;

@WebServlet("/HumanCloud/user/MyPage/ReceivedOffer")
public class UserReceivedOfferServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		CorpService corpService = CorpService.getInstance();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("login");
		int user_id = user.getId();
		
		List<ReceivedOffer> list = service.selectReceivedOffer(user_id);
		List<String> companyList = new ArrayList<>();
		for (ReceivedOffer offer : list) {
			int id = offer.getCompany_id();
			Corp corp = corpService.selectByIdNo(id);
			companyList.add(corp.getName());
		}
		
		req.setAttribute("offerList", list);
		req.setAttribute("companyList", companyList);
		req.getRequestDispatcher("/WEB-INF/user_view/job_offer.jsp").forward(req, resp);
	}
}
