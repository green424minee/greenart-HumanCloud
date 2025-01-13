package kr.co.green.corp;

import kr.co.greenart.user.Resume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Corp {
	private int id;
	private String corpid;
	private String password;
	
	private String businessRegNo; //사업자번호
	private String name; //회사 이름
	
	private String contact; //연락처
	private String email; //회사 이메일
	private String owner; //대표자

	private String address; //회사 주소

}
