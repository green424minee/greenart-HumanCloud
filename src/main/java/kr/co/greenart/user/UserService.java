package kr.co.greenart.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.UserMapper;
import kr.co.greenart.util.DBUtil;

public class UserService {
	private final static UserService INSTANCE = new UserService();
	
	private UserService() {};
	
	public static UserService getInstance() {
		return INSTANCE;
	}
	
	public int insertUser(User user) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.insertUser(user);
			session.commit();
			return row;
		}
	}

	public User selectById(String userName) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			User user = mapper.selectById(userName);
			return user;
		}
	}

	public int updateUser(User update) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.updateUser(update);
			session.commit();
			
			return row;
		}
	}

	public int updateDefaultResume(String userName, int resume_id) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.updateDefaultResume(userName, resume_id);
			session.commit();
			
			return row;
		}
	}

	public List<ReceivedOffer> selectReceivedOffer(int user_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			return mapper.selectReceivedOffer(user_id);
		}
	}
}
