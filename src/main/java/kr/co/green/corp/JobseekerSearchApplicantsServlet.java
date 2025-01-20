package kr.co.green.corp;
//구직자 검색
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.greenart.resume.RepResume;
import kr.co.greenart.resume.ResumeService;
import kr.co.greenart.util.ValidatorUtil;

@WebServlet("/HumanCloud/corp/SearchApplicantsServlet")
public class JobseekerSearchApplicantsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/corp_views/jobseekerSearchApplicants.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResumeService service = ResumeService.getInstance();
        String school_typeParam = req.getParameter("school_type");
        String industryParam = req.getParameter("industry");
        
        if (ValidatorUtil.isNullOrEmpty(school_typeParam)) {
        	school_typeParam = "";
		}
		if (ValidatorUtil.isNullOrEmpty(industryParam)) {
			industryParam = "";
		}
        
		String school_type = "%" + school_typeParam + "%";
		String industry = "%" + industryParam + "%";
        String keyword = "%" + req.getParameter("keyword") + "%";
        List<RepResume> list = service.selectByCondition(school_type, industry, keyword);
        
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/corp_views/jobseekerSearchApplicants.jsp").forward(req, resp);
    }
}
