package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import ko.co.green.recruitment.Recruitment;
import ko.co.green.recruitment.RecruitmentList;

public interface RecruitmentMapper {
	@Select("SELECT id, name, contact, email, website, address, industry, title, description, end_date, updated_at FROM recruitments")
	@Results(id = "recruitmentList"
			, value = {
			@Result(column = "id", property = "id"),
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
	
	@Select("SELECT id, name, contact, email, website, address, industry, title, description, end_date, updated_at"
			+ " FROM human_cloud.recruitments"
			+ " WHERE address LIKE #{region}"
			+ " AND ( industry LIKE #{industry} )"
			+ " AND ( title LIKE #{keyword} OR name LIKE #{keyword} )")
	@ResultMap("recruitmentList")
	List<RecruitmentList> selectByCondition(@Param("region") String region,
											@Param("industry") String industry,
											@Param("keyword") String keyword);
	
	@Select("SELECT id, company_id, status, title, description, salary, end_date, created_at, updated_at FROM recruitment WHERE id = #{recruitmentId}")
	@Results(value = {
			@Result(column = "id", property = "id"),
			@Result(column = "company_id", property = "company_id"),
			@Result(column = "status", property = "status"),
			@Result(column = "title", property = "title"),
			@Result(column = "description", property = "description"),
			@Result(column = "salary", property = "salary"),
			@Result(column = "end_date", property = "end_date"),
			@Result(column = "updated_at", property = "updated_at"),
			@Result(column = "created_at", property = "created_at")
	})
	Recruitment selectById(int recruitmentId);

	

	//동욱 공고등록
	@Insert("INSERT INTO recruitment (company_id, title, description,school_type, salary, end_date) "
		      + "VALUES (#{company_id}, #{title}, #{description}, #{school_type}, #{salary}, #{end_date})")
		int insertRecruitment(Recruitment insert);

	//동욱 공고 전체 조회
	@Select("SELECT * FROM human_cloud.recruitment WHERE company_id = #{companyId}")
	List<Recruitment> selectByCompanyId(@Param("companyId") int companyId);
	//동욱 공고 진행중,마감 관련
	@Select("SELECT * FROM human_cloud.recruitment WHERE company_id = #{companyId} AND status = #{status}")
	List<Recruitment> selectByCompanyIdAndStatus(@Param("companyId") int companyId, @Param("status") String status);
	//동욱 공고삭제
	@Update("UPDATE recruitment SET status = 'expired' WHERE id = #{recruitmentId} AND company_id = #{companyId}")
	int updateStatusToExpired(@Param("recruitmentId") int recruitmentId, @Param("companyId") int companyId);
	//동욱 공고 수정
	@Update("UPDATE recruitment SET title=#{title}, description=#{description}, " +
	        "school_type=#{school_type}, salary=#{salary}, end_date=#{end_date}, " +
	        "status=#{status} " +
	        "WHERE id=#{id} AND company_id=#{company_id}")
	int updateRecruitment(Recruitment recruitment);
	//동욱 공고 삭제
	@Delete("DELETE FROM recruitment WHERE id = #{recruitmentId} AND company_id = #{companyId}")
	int deleteRecruitment(@Param("recruitmentId") int recruitmentId, @Param("companyId") int companyId);



	
}



