package kr.co.green.corp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HumanCloud/corp/Signin")
public class CorpSigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/corp_views/corpsignin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--- 사용자 요청이 매핑되었어요 ---");
        
        String corpId = req.getParameter("corpid");
        String password = req.getParameter("password");
        
        CorpService service = CorpService.getInstance();
        Corp corp = service.selectById(corpId);
        
        if (corp != null && corp.getPassword().equals(password)) {
            System.out.println("--- 로그인 성공 ---");
            
            HttpSession session = req.getSession();
            session.setAttribute("corpId", corpId);
            
            // 기업 인덱스 페이지로 리다이렉트
            resp.sendRedirect(req.getContextPath() + "/HumanCloud/corpindex");
            
        } else {
            System.out.println("--- 로그인 실패 ---");
            
            
            req.setAttribute("loginFailed", true);
            req.getRequestDispatcher("/WEB-INF/corp_views/corpsignin.jsp").forward(req, resp);
        }
    }
}
