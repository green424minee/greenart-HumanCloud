package kr.co.greeanart.scrap;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.user.User;

@WebServlet("/HumanCloud/user/scrapList")
public class ScrapServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ScrapService service = ScrapService.getInstance();
		User user = (User) session.getAttribute("login");
		int userId = user.getId();
		
		// init
		List<Scrap> scrapList = service.selectScraps(userId);
		
		String formType = req.getParameter("formType");
		if(formType != null) {
			// 요청종류 구분
			switch(req.getParameter("formType")) {
			case "sort":
				String sortType = req.getParameter("sortType");
				
				// 정렬종류 구분
				switch(sortType) {
				case "scrap_at_asc":
					sortScrapAtAsc(scrapList);
					break;
					
				case "end_date_asc":
					sortEndDateAsc(scrapList);
					break;
				}
				
				req.setAttribute("selectedSortType", sortType);
			}
		}
		
		req.setAttribute("scrapList", scrapList);
		req.setAttribute("scrapCount", scrapList.size());
		req.getRequestDispatcher("/WEB-INF/user_view/scrapList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ScrapService service = ScrapService.getInstance();
		User user = (User) session.getAttribute("login");
		int userId = user.getId();
		
		// 요청종류 구분
		switch(req.getParameter("formType")) {
		case "scrap": // from recruitment.jsp
			int recrId = Integer.parseInt(req.getParameter("recrId"));
			service.insertScrap(userId, recrId);
			break;
			
		case "delete": // from scrapList.jsp
			int id = Integer.parseInt(req.getParameter("id"));
			service.deleteScrap(id);
			break;
		}
		
		resp.sendRedirect(req.getHeader("referer"));
	}

	private void sortScrapAtAsc(List<Scrap> scrapList) {
		scrapList.sort(Comparator.comparing(Scrap::getScrap_at));
	}
	
	private void sortEndDateAsc(List<Scrap> scrapList) {
		scrapList.sort(Comparator.comparing(Scrap::getEnd_date));
	}
}
