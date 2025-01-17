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

//공고 등록

@WebServlet("/HumanCloud/corp/ManageJobsCreateServlet")
public class ManageJobsCreateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecruitmentService service = RecruitmentService.getInstance();
		
		req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsCreate.jsp" )
			.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 기업 정보 수정때 처럼 정보를 받아와서? 받아올필요가 없음 > 담아서 보내기!
				//또 로그인한 사람만 이용 할 수 있게
				//Recruitment 참고!!
		//폼에서 포스트로 보내면
		//그걸 db에 올릴수 있게끔
			//Recruitment의 서비스에 작성하기 //매핑에도 넣을 수 있는 코드를 짜야함.
		
		//서비스 싱글톤을 쓰기위해서
		RecruitmentService service = RecruitmentService.getInstance();

		System.out.println("=== 공고 등록 처리 시작 ===");
        
        // 세션에서 기업 정보 가져오기
        HttpSession session = req.getSession();
        Corp corp = (Corp) session.getAttribute("corp");
        System.out.println("로그인 기업 ID: " + corp.getId());
        
        // 요청 파라미터 인코딩 설정
        req.setCharacterEncoding("UTF-8");
        
        // 폼 데이터를 Recruitment 객체에 설정
        Recruitment recruitment = new Recruitment();
        recruitment.setCompany_id(corp.getId()); //로그인한사람
        recruitment.setTitle(req.getParameter("recruitmentTitle"));
        recruitment.setDescription(req.getParameter("recruitmentdescription")); // JSP의 name 속성과 맞춤
        recruitment.setSalary(Integer.parseInt(req.getParameter("recruitmentSalary")));
        //학력 추가해줘야함
        String school_type = req.getParameter("school_type");
        recruitment.setSchool_type(school_type);
        
        //로컬데이트는 데이터 타입이 다르니까 변환해서 스트링에 넣어서 적어줘야함 0000-00-00 
        String recruitmentEndDate = req.getParameter("recruitmentEnd_date");
        LocalDate recruitmentEnd_date = LocalDate.parse(recruitmentEndDate);
        recruitment.setEnd_date(recruitmentEnd_date);
        
        
        
        //저장
        try {
            int result = service.insertRecruitment(recruitment);
            System.out.println("등록 결과: " + (result > 0 ? "성공" : "실패"));
            
            if (result > 0) {
                // 등록 성공 시 공고 관리 페이지로 리다이렉트
                resp.sendRedirect(req.getContextPath() + "/HumanCloud/corp/ManageJobsServlet");
            } else {
                // 등록 실패 시 에러 처리
                req.setAttribute("error", "공고 등록에 실패했습니다.");
                req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsCreate.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("=== 오류 발생 ===");
            System.out.println("오류 메시지: " + e.getMessage());
            req.setAttribute("error", "공고 등록 중 오류가 발생했습니다.");
            req.getRequestDispatcher("/WEB-INF/ManageJob/manageJobsCreate.jsp").forward(req, resp);
        }
    }
}