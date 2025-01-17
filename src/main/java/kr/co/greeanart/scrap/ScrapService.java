package kr.co.greeanart.scrap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.ScrapMapper;
import kr.co.greenart.user.User;
import kr.co.greenart.util.DBUtil;

public class ScrapService {
	private static ScrapService instance = new ScrapService();

	public static ScrapService getInstance() {
		return instance;
	}

	private ScrapService() {}
	
	public int selectUserId(String username) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			ScrapMapper mapper = session.getMapper(ScrapMapper.class);
			return mapper.selectUserId(username);
		}
	}
	
	public User selectUser(int userId) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			ScrapMapper mapper = session.getMapper(ScrapMapper.class);
			return mapper.selectUser(userId);
		}
	}
	
	public List<Scrap> selectScraps(int userId) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			ScrapMapper mapper = session.getMapper(ScrapMapper.class);
			return mapper.selectScraps(userId);
		}
	}
	
	public int insertScrap(int userId, int recrId) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			ScrapMapper mapper = session.getMapper(ScrapMapper.class);
			int rows = mapper.insertScrap(userId, recrId);
			if(rows > 0) {
				session.commit();
			}
			
			return rows;
		}
	}
}
