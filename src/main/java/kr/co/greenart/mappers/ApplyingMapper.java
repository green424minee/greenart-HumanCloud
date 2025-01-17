package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import kr.co.greenart.apply.Apply;

public interface ApplyingMapper {
	@Select("SELECT id, recruitment_id, user_id, resume_id, status, applied_at FROM apply"
			+ " WHERE user_id = #{user_id} ORDER BY applied_at DESC")
	@Results(id = "applyResult",
			value = {
					@Result(column = "id", property = "id"),
					@Result(column = "recruitment_id", property = "recruitment_id"),
					@Result(column = "user_id", property = "user_id"),
					@Result(column = "resume_id", property = "resume_id"),
					@Result(column = "status", property = "status"),
					@Result(column = "applied_at", property = "applied_at")
			})
	List<Apply> selectAll(int user_id);
	
	@Insert("INSERT INTO apply (recruitment_id, user_id, resume_id)"
			+ " VALUES (#{recruitment_id}, #{user_id}, #{resume_id})")
	int insertApplyment(Apply apply);
	
	
}
