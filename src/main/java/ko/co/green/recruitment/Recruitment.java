package ko.co.green.recruitment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

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
	private String status; //상태
	private String title;
	private String description;//설명
	// TODO contetn data형으로 추가    // private byte[] content; 
	
	//동욱 학력 추가..
    private String school_type;
    //동욱 경력 필드 추가
    private String experience; 
	private int salary;
	private LocalDate end_date; //
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
