package ko.co.green.recruitment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.RecruitmentMapper;
import kr.co.greenart.mappers.UserMapper;
import kr.co.greenart.user.User;
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

	public Recruitment selectById(int recruitmentId) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			RecruitmentMapper mapper = session.getMapper(RecruitmentMapper.class);
			Recruitment recruitment = mapper.selectById(recruitmentId);
			
			return recruitment;
		}
	}
	
	//동욱 공고관리페이지에서 공고 가져오기
	public List<Recruitment> getRecruitment(int company_id) {
		try(SqlSession session = DBUtil.getSqlSession()) {
			RecruitmentMapper mapper = session.getMapper(RecruitmentMapper.class);
			List<Recruitment> list = mapper.selectByCompanyId(company_id);

			return list;
		}
	}
	//동욱 공고 등록하기 
	public int insertRecruitment(Recruitment recruitment) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			RecruitmentMapper mapper = session.getMapper(RecruitmentMapper.class);
			
			int row = mapper.insertRecruitment(recruitment);
			session.commit();
			return row;
		}
	}
	
}









