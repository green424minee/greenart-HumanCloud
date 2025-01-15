package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.greenart.user.User;

public interface UserMapper {
	@Select("SELECT * FROM user")
	@Results(id = "userResults"
			, value = {
					@Result(column = "id", property = "id", id = true)
					, @Result(column = "username", property = "userName")
					, @Result(column = "password", property = "password")
			})
	List<User> selectAll();
	
	@Insert("INSERT INTO user (username, password, name, phone, email, address) "
			+ "VALUES (#{userName}, #{password}, #{name}, #{phone}, #{email}, #{address})")
	int insertUser(User user);
	
	@Select("SELECT id, username, password, name, phone, email, address FROM user WHERE username = #{userName}")
	@Results(id = "user"
			, value = {
			@Result(column = "id", property= "id"),
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
}
