package ko.co.green.managejob;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.green.corp.Corp;

@WebServlet("/HumanCloud/corp/ManageJobsUpdateServlet")
public class ManageJobsUpdateServlet extends HttpServlet {
    private RecruitmentService service = RecruitmentService.getInstance();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int recruitmentId = Integer.parseInt(req.getParameter("recruitmentId"));
        Recruitment recruitment = service.selectById(recruitmentId);
        req.setAttribute("job", recruitment);
        
        req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsUpdate.jsp")
           .forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Corp corp = (Corp) session.getAttribute("corp");
        
        req.setCharacterEncoding("UTF-8");
        
        Recruitment recruitment = new Recruitment();
        recruitment.setId(Integer.parseInt(req.getParameter("recruitmentId")));
        recruitment.setCompany_id(corp.getId());

        recruitment.setStatus(req.getParameter("recruitmentStatus"));
        recruitment.setTitle(req.getParameter("recruitmentTitle"));
        recruitment.setDescription(req.getParameter("recruitmentdescription"));
        recruitment.setSalary(Integer.parseInt(req.getParameter("recruitmentSalary")));
        recruitment.setSchool_type(req.getParameter("school_type"));
        
        String endDate = req.getParameter("recruitmentEnd_date");
        LocalDate end_date = LocalDate.parse(endDate);
        recruitment.setEnd_date(end_date);
        
        try {
            int result = service.updateRecruitment(recruitment);
            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/ManageJobsServlet");
            } else {
                req.setAttribute("error", "공고 수정에 실패했습니다.");
                req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsUpdate.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "공고 수정 중 오류가 발생했습니다.");
            req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsUpdate.jsp").forward(req, resp);
        }
    }
}
