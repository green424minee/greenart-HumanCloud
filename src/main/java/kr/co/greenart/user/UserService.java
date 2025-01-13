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
}
