package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import kr.co.greenart.resume.Education;
import kr.co.greenart.resume.Experience;
import kr.co.greenart.resume.License;
import kr.co.greenart.resume.Resume;

public interface ResumeMapper {
	@Select("SELECT id, user_id, portrait, title, created_at, updated_at"
			+ " FROM resume WHERE user_id = ${user_id} ")
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
	
	@Select("")
	Education selectEducation(int resume_id);
	
	@Select("")
	Experience selectExperience(int resume_id);
	
	@Select("")
	List<License> selectLicense(int resume_id);
}
