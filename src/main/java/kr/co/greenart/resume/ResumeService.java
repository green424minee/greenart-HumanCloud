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

	public int createMyResume(int user_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.createMyResume(user_id);
			session.commit();
			
			return row;
		}
	}

	public int getGeneratedKey() {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			return mapper.getGeneratedKey();
		}
	}

	public int updateResume(int resume_id, String title) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.updateResume(resume_id, title);
			session.commit();
			return row;
		}
	}
	public int createEducation(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.createEducation(resume_id);
			session.commit();
			return row;
		}
	}

	public int updateEducation(Education education) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.updateEducation(education);
			session.commit();
			return row;
		}
	}

	public int createExperience(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.createExperience(resume_id);
			session.commit();
			return row;
		}
	}
	
	public int updateExperience(Experience experience) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.updateExperience(experience);
			session.commit();
			return row;
		}
	}

	public int insertLicense(License license) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.insertLicense(license);
			session.commit();
			return row;
		}
	}

	public int deleteLicense(int license_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.deleteLicense(license_id);
			session.commit();
			return row;
		}
	}

	public int deleteLicenses(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.deleteLicenses(resume_id);
			session.commit();
			return row;
		}
	}

	public int deleteExperience(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.deleteExperience(resume_id);
			session.commit();
			return row;
		}
	}

	public int deleteEducation(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.deleteEducation(resume_id);
			session.commit();
			return row;
		}
	}

	public int deleteResume(int resume_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			ResumeMapper mapper = session.getMapper(ResumeMapper.class);
			
			int row = mapper.deleteResume(resume_id);
			session.commit();
			return row;
		}
	}
}
