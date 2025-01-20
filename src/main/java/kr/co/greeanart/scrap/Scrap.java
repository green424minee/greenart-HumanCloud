package kr.co.greeanart.scrap;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scrap {
	int id;
	int user_id;
	int recruitment_id;
	LocalDate scrap_at;
	
	String corp_name;
	String recr_title;
	LocalDate end_date;
}
