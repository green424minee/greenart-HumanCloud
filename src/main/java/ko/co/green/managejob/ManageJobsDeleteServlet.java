package ko.co.green.managejob;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.green.corp.Corp;

@WebServlet("/HumanCloud/corp/ManageJobsDeleteServlet")
public class ManageJobsDeleteServlet extends HttpServlet {
    private RecruitmentService service = RecruitmentService.getInstance();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== 공고 삭제 처리 시작 ===");
        
        HttpSession session = req.getSession();
        Corp corp = (Corp) session.getAttribute("corp");
        System.out.println("로그인 기업 ID: " + corp.getId());
        
        int recruitmentId = Integer.parseInt(req.getParameter("recruitmentId"));
        System.out.println("삭제할 공고 ID: " + recruitmentId);
        
        try {
            System.out.println("공고 삭제 시도...");
            boolean success = service.deleteRecruitment(recruitmentId, corp.getId());
            
            if (success) {
                System.out.println("공고 삭제 성공!");
                resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/ManageJobsServlet");
            } else {
                System.out.println("공고 삭제 실패: DB 처리 결과 false");
                req.setAttribute("error", "공고 삭제에 실패했습니다.");
                resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/ManageJobsServlet");
            }
        } catch (Exception e) {
            System.out.println("=== 오류 발생 ===");
            System.out.println("오류 메시지: " + e.getMessage());
            System.out.println("오류 상세:");
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/ManageJobsServlet");
        }
        
        System.out.println("=== 공고 삭제 처리 종료 ===");
    }
}
