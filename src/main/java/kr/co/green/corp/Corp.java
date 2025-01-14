package kr.co.green.corp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Corp {
	
    private int id;
    private String corpid;
    private String password;
    private String business_reg_no;
    private byte[] image;        // BLOB 타입을 위한 byte array
    private String name;
    private String description;  // MEDIUMTEXT 타입
    private String contact;
    private String email;
    private String owner;
    private String industry;
//	private String estDate;      // DATE 타입
    private java.sql.Date estDate;  // String estDate를 수정
    private String website;      // VARCHAR(50)
    private Integer emp_count;    // INT, nullable
    private Long sales;          // BIGINT
    private String address;
}
