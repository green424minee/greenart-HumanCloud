package ko.co.green.recruitment;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruitment {
	private int id;
	private int company_id;
	private String status;
	private String title;
	private String description;
	// TODO contetn data형으로 추가    // private byte[] content; 
	private int salary;
	private LocalDate end_date;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
