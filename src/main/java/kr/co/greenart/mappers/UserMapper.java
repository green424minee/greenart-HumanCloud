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
					, @Result(column = "userid", property = "userId")
					, @Result(column = "password", property = "password")
			})
	List<User> selectAll();
	
	@Insert("INSERT INTO user (userid, password, name, phone, email, address) "
			+ "VALUES (#{userId}, #{password}, #{name}, #{phone}, #{email}, #{address})")
	int insertUser(User user);
	
	@Select("SELECT userid, password, name FROM user WHERE userid = #{userId}")
	@Results(value = {
			@Result(column = "userid", property = "userId")
			, @Result(column = "password", property = "password")
			, @Result(column = "name", property = "name")
	})
	User selectById(String userId);
}
