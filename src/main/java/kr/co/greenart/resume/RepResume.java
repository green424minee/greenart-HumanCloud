package kr.co.greenart.resume;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepResume {
	private int resume_id;
	private int user_id;
	private String resume_title;
	private String user_name;
	private String user_email;
	private String school_type;
	private String school_status;
	private String industry;
	private String dept;
	private String position;
	private String company_status;
}
