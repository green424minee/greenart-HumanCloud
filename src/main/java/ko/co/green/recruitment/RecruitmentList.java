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
public class RecruitmentList {
	private int id;
	private String name;
	private String contact;
	private String email;
	private String website;
	private String address;
	private String industry;
	private String title;
	private String description;
	private LocalDate end_date;
	private LocalDateTime updated_at;
}
