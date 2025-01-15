package kr.co.greenart.resume;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
	// 학력
	private int id;
	private int resume_id;
	private String school_type;
	private String school_name;
	private String status;
	private LocalDate adm_at;
	private LocalDate grad_at;
}
