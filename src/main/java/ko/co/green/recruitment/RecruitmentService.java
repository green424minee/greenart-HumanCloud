package ko.co.green.recruitment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.RecruitmentMapper;
import kr.co.greenart.util.DBUtil;

public class RecruitmentService {
private final static RecruitmentService INSTANCE = new RecruitmentService();
    
    private RecruitmentService() {}
    
    public static RecruitmentService getInstance() {
        return INSTANCE;
    }

	public List<RecruitmentList> selectAll() {
		try (SqlSession session = DBUtil.getSqlSession()) {
			RecruitmentMapper mapper = session.getMapper(RecruitmentMapper.class);
			List<RecruitmentList> list = mapper.selectAll();
			
			return list;
		}
	}

	public List<RecruitmentList> selectByCondition(String region, String industry, String keyword) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			RecruitmentMapper mapper = session.getMapper(RecruitmentMapper.class);
			List<RecruitmentList> list = mapper.selectByCondition(region, industry, keyword);
			
			return list;
		}
	}
}
