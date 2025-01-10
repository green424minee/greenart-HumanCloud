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
	
	public List<User> selectAll() {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			List<User> list = mapper.selectAll();
			return list;
		}
	}
	
	public int insertUser(User user) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			int row = mapper.insertUser(user);
			session.commit();
			return row;
		}
	}

	public User selectById(String userId) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			User user = mapper.selectById(userId);
			return user;
		}
	}
}
