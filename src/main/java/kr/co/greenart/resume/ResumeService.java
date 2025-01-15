package kr.co.greenart.resume;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.ResumeMapper;
import kr.co.greenart.util.DBUtil;

public class ResumeService {
	private final static ResumeService INSTANCE = new ResumeService();
	
	private ResumeService () {}
	
	public static ResumeService getInstance() {
		return INSTANCE;
	}
	
	public List<Resume> selectMyResumeList(int user_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			List<Resume> list = mapper.selectMyResumeList(user_id);
			return list;
		}
	}

	public Resume selectMyResume(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			Resume resume = mapper.selectMyResume(resume_id);
			return resume;
		}
	}
	
	public Education selectEducation(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			return mapper.selectEducation(resume_id);
		}
	}
	public Experience selectExperience(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			return mapper.selectExperience(resume_id);
		}
	}
	public List<License> selectLicense(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			return mapper.selectLicense(resume_id);
		}
	}
}
