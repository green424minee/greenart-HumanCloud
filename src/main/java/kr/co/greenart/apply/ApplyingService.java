package kr.co.greenart.apply;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.ApplyingMapper;
import kr.co.greenart.util.DBUtil;

public class ApplyingService {
	private final static ApplyingService INSTANCE = new ApplyingService();
	
	private ApplyingService() {}
	
	public static ApplyingService getInstance() {
		return INSTANCE;
	}

	public int insertApplyment(Apply apply) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
			
			int row = mapper.insertApplyment(apply);
			session.commit();
			
			return row;
		}
	}
}
