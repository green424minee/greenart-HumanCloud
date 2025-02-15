package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.greenart.apply.Apply;

public interface ApplyingMapper {

    
	@Insert("INSERT INTO apply (recruitment_id, user_id, resume_id)"
			+ " VALUES (#{recruitment_id}, #{user_id}, #{resume_id})")
	int insertApplyment(Apply apply);
    
    // 공고별 지원자 조회
    @Select("SELECT * FROM apply WHERE recruitment_id = #{recruitment_id}")
    List<Apply> selectByRecruitmentId(int recruitment_id);
    
    // 공고별 상태별 지원자 조회
    @Select("SELECT * FROM apply WHERE recruitment_id = #{recruitment_id} AND status = #{status}")
    List<Apply> selectByRecruitmentIdAndStatus(@Param("recruitment_id") int recruitment_id, 
                                              @Param("status") String status);

    // 지원 상태 업데이트
    @Update("UPDATE apply SET status = #{status} WHERE id = #{apply_id}")
    int updateStatus(@Param("apply_id") int apply_id, 
                    @Param("status") String status);
    
    // 지원서 상세 조회
    @Select("SELECT * FROM apply WHERE id = #{applyId}")
    Apply selectById(int applyId);
    
    //지원자 이름 조회
    @Select("SELECT u.name FROM human_cloud.user u " +
            "WHERE u.id = (SELECT user_id FROM human_cloud.apply WHERE id = #{apply_id}) " +
            "AND u.default_resume_id = (SELECT resume_id FROM human_cloud.apply WHERE id = #{apply_id})")
    String getUserNameByApplyId(int apply_id);

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
	

	
	@Delete("DELETE FROM apply WHERE id = #{id}")
	int deleteApply(int id);

}
