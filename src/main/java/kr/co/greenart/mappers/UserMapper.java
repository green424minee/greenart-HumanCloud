package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.greenart.user.ReceivedOffer;
import kr.co.greenart.user.User;

public interface UserMapper {
	@Insert("INSERT INTO user (username, password, name, phone, email, address) "
			+ "VALUES (#{userName}, #{password}, #{name}, #{phone}, #{email}, #{address})")
	int insertUser(User user);
	
	@Select("SELECT id, default_resume_id, username, password, name, phone, email, address FROM user WHERE username = #{userName}")
	@Results(id = "user"
			, value = {
			@Result(column = "id", property= "id"),
			@Result(column = "default_resume_id", property= "default_resume_id"),
			@Result(column = "username", property = "userName"),
			@Result(column = "name", property = "name"),
			@Result(column = "phone", property = "phone"),
			@Result(column = "email", property = "email"),
			@Result(column = "address", property = "address")
	})
	User selectById(String userName);
	
	@Update("UPDATE user SET password = #{ password }, phone = #{ phone }, email = #{ email }, address = #{ address }"
			+ " WHERE username = #{ userName }")
	int updateUser(User update);
	
	@Update("UPDATE user SET default_resume_id = #{default_resume_id} WHERE username = #{userName}")
	int updateDefaultResume(@Param("userName") String userName,
							@Param("default_resume_id") int resume_id);
	
	@Select("SELECT user_id, company_id, status, offered_at FROM job_offer WHERE user_id = #{user_id}")
	List<ReceivedOffer> selectReceivedOffer(int user_id);
}
