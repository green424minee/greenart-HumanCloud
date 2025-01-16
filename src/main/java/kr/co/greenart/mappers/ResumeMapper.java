package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.greenart.resume.Education;
import kr.co.greenart.resume.Experience;
import kr.co.greenart.resume.License;
import kr.co.greenart.resume.Resume;

public interface ResumeMapper {
	@Select("SELECT id, user_id, portrait, title, created_at, updated_at"
			+ " FROM resume WHERE user_id = ${user_id} ORDER BY updated_at DESC")
	@Results(id = "resumeResult",
			value = {
					@Result(column = "id", property = "id", id=true),
					@Result(column = "user_id", property = "user_id"),
					@Result(column = "portrait", property = "portrait"),
					@Result(column = "title", property = "title"),
					@Result(column = "created_at", property = "created_at"),
					@Result(column = "updated_at", property = "updated_at")
			})
	List<Resume> selectMyResumeList(int user_id);
	
	@Select("SELECT id, user_id, portrait, title, created_at, updated_at"
			+ " FROM resume WHERE id = ${resume_id}")
	@ResultMap("resumeResult")
	Resume selectMyResume(int resume_id);
	
	@Select("SELECT id, resume_id, school_type, school_name, status, adm_at, grad_at"
			+ " FROM education WHERE resume_id = #{ resume_id }")
	Education selectEducation(int resume_id);
	
	@Select("SELECT id, resume_id, job_title, dept, position, prev_role, status, join_at, leave_or_ongoing_at"
			+ " FROM experience WHERE resume_id = #{ resume_id }")
	Experience selectExperience(int resume_id);
	
	@Select("SELECT id, resume_id, value, issued_at"
			+ " FROM license WHERE resume_id = #{ resume_id }")
	List<License> selectLicense(int resume_id);
	
	@Insert("INSERT INTO resume (user_id) VALUES (#{ user_id })")
	int createMyResume(int user_id);
	
	@Select("SELECT LAST_INSERT_ID()")
	int getGeneratedKey();
//	아이디만 이용해서 컬럼을 만들고 생성된 컬럼의 키를 돌려받는 방법
	
	@Update("UPDATE resume SET title = #{title} WHERE id = #{resume_id} ")
	int updateResume(@Param("resume_id") int resume_id,
					@Param("title") String title);
	
	@Update("UPDATE education"
			+ " SET school_type = #{school_type}, school_name = #{school_name}, status = #{status}, adm_at = #{adm_at}, grad_at=#{grad_at}"
			+ " WHERE resume_id = #{resume_id}")
	int updateEducation(Education education);
	
	@Update("UPDATE experience"
			+ " SET job_title = #{job_title}, dept = #{dept}, position = #{position}, prev_role = #{prev_role}, status = #{status}, join_at = #{join_at}, leave_or_ongoing_at = #{leave_or_ongoing_at}"
			+ " WHERE resume_id = #{resume_id}")
	int updateExperience(Experience experience);
	
	@Insert("INSERT INTO license (resume_id, value, issued_at)"
			+ " VALUES (#{resume_id}, #{value}, #{issued_at})")
	int insertLicense(License license);

//	@Insert("INSERT INTO resume (user_id) VALUES #{ user_id }")
//	@Options(keyColumn = "id", useGeneratedKeys = true)
//	int createResume(Resume resume);
//	객체를 전달해서 해당 객체에 바로 id를 담는 방법
}
