package kr.co.greenart.user;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ko.co.green.recruitment.RecruitmentList;
import ko.co.green.recruitment.RecruitmentService;

@WebServlet({"", "/index"})
public class UserIndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService recruitmentService = RecruitmentService.getInstance();
		
		List<RecruitmentList> selectAll = recruitmentService.selectAll();
		req.setAttribute("list", selectAll);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
