package kr.co.green.corp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greenart.mappers.CorpMapper;
import kr.co.greenart.util.DBUtil;


public class CorpService {
    private final static CorpService INSTANCE = new CorpService();
    
    private CorpService() {}
    
    public static CorpService getInstance() {
        return INSTANCE;
    }
    
    public List<Corp> selectAll() {
        try (SqlSession session = DBUtil.getSqlSession()) {
            CorpMapper mapper = session.getMapper(CorpMapper.class);
            
            List<Corp> list = mapper.selectAll();
            return list;
        }
    }
    
    public int insertCorp(Corp corp) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            CorpMapper mapper = session.getMapper(CorpMapper.class);
            
            int row = mapper.insertCorp(corp);
            session.commit();
            return row;
        }
    }

    public Corp selectById(String corpId) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            CorpMapper mapper = session.getMapper(CorpMapper.class);
            return mapper.selectById(corpId);
        }
    }

    public int updateCorp(Corp corp) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            CorpMapper mapper = session.getMapper(CorpMapper.class);
            
            int row = mapper.updateCorp(corp);
            session.commit();
            return row;
        }
    }

	  public Corp selectByIdNo(int id) {
       try (SqlSession session = DBUtil.getSqlSession()) {
              CorpMapper mapper = session.getMapper(CorpMapper.class);
              return mapper.selectByIdNo(id);
        }
    }

	public int insertOffer(int user_id, int company_id) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			CorpMapper mapper = session.getMapper(CorpMapper.class);
			int row = mapper.insertOffer(user_id, company_id);
			session.commit();
			return row;
		}
	}
}
