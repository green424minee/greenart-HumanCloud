package kr.co.greenart.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceivedOffer {
	private int user_id;
	private int company_id;
	private String status;
	private LocalDateTime offered_at;
}
