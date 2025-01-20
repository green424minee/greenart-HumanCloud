package ko.co.green.managejob;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentService;
import kr.co.green.corp.Corp;
import kr.co.greenart.apply.Apply;
import kr.co.greenart.apply.ApplyingService;
import kr.co.greenart.resume.Education;
import kr.co.greenart.resume.Experience;
import kr.co.greenart.resume.License;
import kr.co.greenart.resume.Resume;
import kr.co.greenart.resume.ResumeService;




@WebServlet("/HumanCloud/corp/ManageApplicantDetailServlet")
public class ManageApplicantDetailServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Corp corp = (Corp) session.getAttribute("corp");
        
        String applyId = req.getParameter("apply_id");
        if (applyId == null || applyId.trim().isEmpty()) {
            resp.sendRedirect("ManageApplicantsServlet");
            return;
        }
        
        ApplyingService applyingService = ApplyingService.getInstance();
        ResumeService resumeService = ResumeService.getInstance();
        
       // 지원 정보 조회
        Apply apply = applyingService.getApplyById(Integer.parseInt(applyId));
        
        // 지원자 이름 조회 추가
        String userName = applyingService.getUserNameByApplyId(apply.getId());
        
        // 이력서 상세 정보 조회
        Resume resume = resumeService.selectMyResume(apply.getResume_id());
        Education education = resumeService.selectEducation(apply.getResume_id());
        Experience experience = resumeService.selectExperience(apply.getResume_id());
        List<License> licenses = resumeService.selectLicense(apply.getResume_id());
        
        // 경력 기간과 최종 학력 계산 (ResumeService 사용)
        String experiencePeriod = resumeService.calculateExperiencePeriod(experience);
        String finalEducation = resumeService.getFinalEducation(education);
        
        // request에 속성 설정
        req.setAttribute("apply", apply);
        req.setAttribute("resume", resume);
        req.setAttribute("education", education);
        req.setAttribute("experience", experience);
        req.setAttribute("licenses", licenses);
        req.setAttribute("experiencePeriod", experiencePeriod);
        req.setAttribute("finalEducation", finalEducation);
        req.setAttribute("userName", userName);  // 사용자 이름 추가
        
        req.getRequestDispatcher("/WEB-INF/ManageJob/manageApplicantDetail.jsp").forward(req, resp);
    }
}
