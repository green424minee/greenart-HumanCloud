package kr.co.greenart.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.greenart.resume.Resume;
import kr.co.greenart.resume.ResumeService;
import kr.co.greenart.user.User;

public class UserResumeFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ResumeService service = ResumeService.getInstance();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		
		String id = req.getParameter("id");
		int resume_id = Integer.parseInt(id);
		Resume resume = service.selectMyResume(resume_id);
		int user_id = resume.getUser_id();
		User user = (User) session.getAttribute("login");
		
		if (user_id == user.getId()) {
			chain.doFilter(request, response);
		} else {
			resp.sendError(400, "Invalid action");
		}
	}
}
