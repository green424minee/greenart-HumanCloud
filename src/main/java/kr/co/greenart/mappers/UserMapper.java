package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
	
	@Select("SELECT username, password, name FROM user WHERE username = #{userName}")
	@Results(value = {
			@Result(column = "username", property = "userName")
			, @Result(column = "password", property = "password")
			, @Result(column = "name", property = "name")
	})
	User selectById(String userName);
}
