package kr.co.greenart.apply;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.ApplyingMapper;
import kr.co.greenart.resume.Education;
import kr.co.greenart.resume.Experience;
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
	
	//동욱추가
	public List<Apply> getAppliesByRecruitmentId(int recruitment_id) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
            return mapper.selectByRecruitmentId(recruitment_id);
        }
    }

    public List<Apply> getAppliesByRecruitmentIdAndStatus(int recruitment_id, String status) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
            return mapper.selectByRecruitmentIdAndStatus(recruitment_id, status);
        }
    }

    public int updateApplyStatus(int apply_id, String status) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
            int result = mapper.updateStatus(apply_id, status);
            session.commit();
            return result;
        }
    }

    public Apply getApplyById(int applyId) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
            return mapper.selectById(applyId);
        }
    }
    
    //이름조회
    public String getUserNameByApplyId(int apply_id) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ApplyingMapper mapper = session.getMapper(ApplyingMapper.class);
            return mapper.getUserNameByApplyId(apply_id);
        }
    }




    
}