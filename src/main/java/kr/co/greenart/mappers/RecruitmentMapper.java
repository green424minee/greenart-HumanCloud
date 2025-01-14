package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import ko.co.green.recruitment.RecruitmentList;

public interface RecruitmentMapper {
	@Select("SELECT name, contact, email, website, address, industry, title, description, end_date, updated_at FROM recruitments")
	@Results(id = "recruitmentList"
			, value = {
			@Result(column = "name", property = "name"),
			@Result(column = "contact", property = "contact"),
			@Result(column = "email", property = "email"),
			@Result(column = "website", property = "website"),
			@Result(column = "address", property = "address"),
			@Result(column = "industry", property = "industry"),
			@Result(column = "title", property = "title"),
			@Result(column = "description", property = "description"),
			@Result(column = "end_date", property = "end_date"),
			@Result(column = "updated_at", property = "updated_at"),
	})
	List<RecruitmentList> selectAll();
	
	@Select("SELECT name, contact, email, website, address, industry, title, description, end_date, updated_at"
			+ " FROM human_cloud.recruitments"
			+ " WHERE address LIKE #{region}")
	@ResultMap("recruitmentList")
	List<RecruitmentList> selectByRegion(String region);
	
	@Select("SELECT name, contact, email, website, address, industry, title, description, end_date, updated_at"
			+ " FROM human_cloud.recruitments"
			+ " WHERE industry LIKE #{industry}")
	@ResultMap("recruitmentList")
	List<RecruitmentList> selectByIndustry(String industry);
	
	@Select("SELECT name, contact, email, website, address, industry, title, description, end_date, updated_at"
			+ " FROM human_cloud.recruitments"
			+ " WHERE title LIKE #{keyword}")
	@ResultMap("recruitmentList")
	List<RecruitmentList> selectByKeyword(String keyword);
	
	@Select("SELECT name, contact, email, website, address, industry, title, description, end_date, updated_at"
			+ " FROM human_cloud.recruitments"
			+ " WHERE address LIKE #{region}"
			+ " AND ( industry LIKE #{industry} )"
			+ " AND ( title LIKE #{keyword} OR name LIKE #{keyword} )")
	@ResultMap("recruitmentList")
	List<RecruitmentList> selectByCondition(@Param("region") String region,
											@Param("industry") String industry,
											@Param("keyword") String keyword);
}
