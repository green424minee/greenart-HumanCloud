package ko.co.green.managejob;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.co.greenart.resume.Resume;
import kr.co.greenart.resume.ResumeService;

@WebServlet("/HumanCloud/corp/ManageApplicantsServlet")
public class ManageApplicantsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Corp corp = (Corp) session.getAttribute("corp");
        
        ResumeService resumeService = ResumeService.getInstance();
        ApplyingService applyingService = ApplyingService.getInstance();
        RecruitmentService recruitmentService = RecruitmentService.getInstance();
        
        List<Recruitment> recruitments = recruitmentService.getRecruitmentByStatus(corp.getId(), "active");
        req.setAttribute("recruitments", recruitments);
        
        String id = req.getParameter("id");
        String status = req.getParameter("status");
        
        if (id != null && !id.trim().isEmpty()) {
            int recruitment_id = Integer.parseInt(id);
            List<Apply> applies;
            
            if (status != null && !status.equals("all")) {
                applies = applyingService.getAppliesByRecruitmentIdAndStatus(recruitment_id, status);
            } else {
                applies = applyingService.getAppliesByRecruitmentId(recruitment_id);
            }
            
            Map<Integer, String> nameMap = new HashMap<>();
            Map<Integer, String> educationMap = new HashMap<>();
            Map<Integer, String> experienceMap = new HashMap<>();
            Map<Integer, Resume> resumeMap = new HashMap<>();
            
            for (Apply apply : applies) {
                Education education = resumeService.selectEducation(apply.getResume_id());
                Experience experience = resumeService.selectExperience(apply.getResume_id());
                Resume resume = resumeService.selectMyResume(apply.getResume_id());
                
                String userName = applyingService.getUserNameByApplyId(apply.getId());
                String finalEducation = resumeService.getFinalEducation(education);
                String experiencePeriod = resumeService.calculateExperiencePeriod(experience);
                
                nameMap.put(apply.getId(), userName);
                educationMap.put(apply.getId(), finalEducation);
                experienceMap.put(apply.getId(), experiencePeriod);
                resumeMap.put(apply.getId(), resume);
            }
            
            req.setAttribute("nameMap", nameMap);
            req.setAttribute("educationMap", educationMap);
            req.setAttribute("experienceMap", experienceMap);
            req.setAttribute("resumeMap", resumeMap);
            req.setAttribute("applies", applies);
            req.setAttribute("currentRecruitmentId", recruitment_id);
        }
        
        req.getRequestDispatcher("/WEB-INF/ManageJob/manageApplicants.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String applyId = req.getParameter("apply_id");
        String action = req.getParameter("action");
        String recruitmentId = req.getParameter("id");
        
        if (applyId != null && action != null) {
            ApplyingService applyingService = ApplyingService.getInstance();
            applyingService.updateApplyStatus(Integer.parseInt(applyId), action);
        }
        
        String status = req.getParameter("status");
        String redirectUrl = "ManageApplicantsServlet?id=" + recruitmentId;
        if (status != null) {
            redirectUrl += "&status=" + status;
        }
        resp.sendRedirect(redirectUrl);
    }
}
