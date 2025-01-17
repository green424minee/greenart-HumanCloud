package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.greenart.apply.Apply;

public interface ApplyingMapper {
	@Select("SELECT * FROM apply")
	List<Apply> selectAll();
	
	@Insert("INSERT INTO apply (recruitment_id, user_id, resume_id)"
			+ " VALUES (#{recruitment_id}, #{user_id}, #{resume_id})")
	int insertApplyment(Apply apply);
	
	
}
