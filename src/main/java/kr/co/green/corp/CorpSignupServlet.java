package kr.co.green.corp;

import java.io.IOException;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.greenart.util.ValidatorUtil;

@WebServlet("/HumanCloud/corp/Signup")
public class CorpSignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/corp_views/corpsignup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--- 사용자 요청이 매핑되었어요 ---");
        
        CorpService service = CorpService.getInstance();
        String businessRegNo = req.getParameter("business_reg_no");

        // 사업자등록번호 유효성 검사
        if (!isValidBusinessRegNo(businessRegNo)) {
            req.setAttribute("error", "유효하지 않은 사업자등록번호입니다.");
            req.getRequestDispatcher("/WEB-INF/corp_views/corpsignup.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        String corpId = req.getParameter("corpid");
        String password = req.getParameter("password");
        String passwordCheck = req.getParameter("passwordCheck");
        String contact = req.getParameter("contact");
        String email = req.getParameter("email");
        String owner = req.getParameter("owner");
        String address = req.getParameter("address");
        
        if(ValidatorUtil.isPasswordMatch(password, passwordCheck)) {
            Corp corp = Corp.builder()
                .business_reg_no(businessRegNo)
                .name(name)
                .corpid(corpId)
                .password(password)
                .contact(contact)
                .email(email)
                .owner(owner)
                .address(address)
                .build();
            service.insertCorp(corp);
        
            System.out.println("행 삽입 후 view로 포워드 할거예요");
            
            req.getRequestDispatcher("/WEB-INF/corp_views/corpsignupResult.jsp").forward(req, resp);
        } else {
            System.out.println("입력값이 잘못되어서 에러 메시지 view로 포워드 할거예요");
            
            req.setAttribute("error", "비밀번호가 일치하지 않습니다.");
            req.getRequestDispatcher("/WEB-INF/corp_views/corpsignup.jsp").forward(req, resp);
        }
    }

    // 사업자등록번호 유효성 검사 메소드
    private boolean isValidBusinessRegNo(String businessRegNo) {
        // 정규표현식을 사용하여 10자리 숫자인지 확인
        return Pattern.matches("^\\d{10}$", businessRegNo);
    }
}
