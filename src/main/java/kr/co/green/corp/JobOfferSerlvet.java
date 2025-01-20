package kr.co.green.corp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HumanCloud/corp/SearchApplicantsServlet/JobOffer")
public class JobOfferSerlvet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorpService service = CorpService.getInstance();
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		int user_id = Integer.parseInt(id);
		Corp corp = (Corp) session.getAttribute("corp");
		int company_id = corp.getId();
		
		service.insertOffer(user_id, company_id);
		resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/SearchApplicantsServlet");
	}
}
