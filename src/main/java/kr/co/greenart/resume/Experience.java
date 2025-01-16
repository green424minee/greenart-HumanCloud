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
public class Experience {
	// 경력
	private int id;
	private int resume_id;
	private String job_title;
	private String dept;
	private String position;
	private String prev_role;
	private String status;
	private LocalDate join_at;
	private LocalDate leave_or_ongoing_at; // 재직 상태일 경우 입사일과 동일
}
