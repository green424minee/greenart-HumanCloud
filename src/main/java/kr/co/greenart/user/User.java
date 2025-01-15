package kr.co.greenart.user;

import kr.co.greenart.resume.Resume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private int id;
	private String userName;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	private Resume resume;
}
