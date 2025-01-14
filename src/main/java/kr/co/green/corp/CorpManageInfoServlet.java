package kr.co.green.corp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//기업정보관리서블릿입니다.

@WebServlet("/HumanCloud/corp/CorpManageInfo")
public class CorpManageInfoServlet  extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/corp_views/corpManageInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form 에서 전달된 parameter 값 모두 꺼내기
        CorpService corpService = CorpService.getInstance();
        
        
        String name = req.getParameter("name");
        System.out.println("확인: " + name);
        
        String business_reg_no = req.getParameter("business_reg_no");
        System.out.println("확인: " + business_reg_no);

        String description = req.getParameter("description");
        System.out.println("확인: " + description);
        
        String contact = req.getParameter("contact");
        System.out.println("확인: " + contact);
        
        String email = req.getParameter("email");
        System.out.println("확인: " + email);
        
        String owner = req.getParameter("owner");
        System.out.println("확인: " + owner);

        String website = req.getParameter("website");
        System.out.println("확인: " + website);

        int emp_count = Integer.parseInt(req.getParameter("emp_count"));
        System.out.println("확인: " + emp_count);

        long sales = Long.parseLong(req.getParameter("sales"));
        System.out.println("확인: " + sales);

        String address = req.getParameter("address");
        System.out.println("확인: " + address);
        
        byte[] image = req.getParameter("image").getBytes();
        System.out.println("확인: " + image);
		
		// Corp 객체로 만들기
        Corp corp = Corp.builder()
                .name(name)
                .businessRegNo(business_reg_no)
                .description(description)
                .contact(contact)
                .email(email)
                .owner(owner)
                .website(website)
                .empCount(emp_count)
                .sales(sales)
                .address(address)
                .image(image)
                .corpid("test")
                .build();
        corpService.updateCorp(corp);

		
		// CorpService에 update 만들기 & CorpMapper에 update 만들기
		//완료
        
        // CorpService 객체 생성 및 update 메서드 호출

        int result = corpService.updateCorp(corp);
        System.out.println(result);
    }
}
		// 수정되면 결과화면 보여주기


