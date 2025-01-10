package kr.co.greenart.user;

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
	private String userid;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String type;
	private Resume resume;
}
