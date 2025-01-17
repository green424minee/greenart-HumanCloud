package kr.co.greenart.apply;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apply {
	private int id;
	private int recruitment_id;
	private int user_id;
	private int resume_id;
	private String status;
	private LocalDateTime applied_at;
}
