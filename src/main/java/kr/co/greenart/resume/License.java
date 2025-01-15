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
public class License {
	private int id;
	private int resume_id;
	private String value;
	private LocalDate issued_at;
}
