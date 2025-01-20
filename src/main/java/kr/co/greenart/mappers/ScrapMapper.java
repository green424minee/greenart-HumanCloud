package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.greeanart.scrap.Scrap;
import kr.co.greenart.user.User;

public interface ScrapMapper {
	@Select("SELECT user_id FROM user WHERE username = #{username}")
	int selectUserId(String username);
	
	@Select("SELECT * FROM user WHERE user_id = #{userId}")
	User selectUser(int userId);
	
	@Select("SELECT * FROM scrap_view WHERE user_id = #{userId}")
	List<Scrap> selectScraps(int userId);
	
	@Insert("INSERT INTO scrap(user_id, recruitment_id) VALUES(#{userId}, #{recrId})")
	int insertScrap(@Param("userId") int userId, @Param("recrId") int recrId);
	
	@Delete("DELETE FROM scrap WHERE id = #{id}")
	int deleteScrap(int id);
	
	@Select("SELECT count(*) > 0 FROM scrap WHERE user_id = #{userId} AND recruitment_id = #{recrId}")
	boolean isScrapped(@Param("userId") int userId, @Param("recrId") int recrId);
}
