package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import ko.co.green.recruitment.Recruitment;
import kr.co.greeanart.scrap.Scrap;
import kr.co.greenart.user.User;

public interface ScrapMapper {
	@Select("SELECT user_id FROM user WHERE username = #{username}")
	int selectUserId(String username);
	
	@Select("SELECT * FROM user WHERE user_id = #{userId}")
	User selectUser(int userId);
	
//	@Select("SELECT * FROM recruitment WHERE recruitment_id = #{recrId}")
//	Recruitment selectRecr(int recrId);
	
	@Select("SELECT * FROM scrap_view WHERE user_id = #{userId}")
	List<Scrap> selectScraps(int userId);
	
	@Insert("INSERT INTO scrap(user_id, recruitment_id) VALUES(#{userId}, #{recrId})")
	int insertScrap(int userId, int recrId);
}
