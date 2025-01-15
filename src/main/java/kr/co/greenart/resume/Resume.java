package kr.co.greenart.resume;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {
	private int id;
	private int user_id;
	private byte[] portrait;
	private String title;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
