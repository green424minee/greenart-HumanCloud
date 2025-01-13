package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import kr.co.green.corp.Corp;

public interface CorpMapper {
    @Select("SELECT * FROM company")
    @Results(id = "corpResults"
            , value = {
                    @Result(column = "id", property = "id", id = true)
                    , @Result(column = "business_reg_no", property = "businessRegNo")
                    , @Result(column = "name", property = "name")
                    , @Result(column = "userid", property = "userid")
                    , @Result(column = "password", property = "password")
                    , @Result(column = "phone", property = "phone")
                    , @Result(column = "email", property = "email")
            })
    List<Corp> selectAll();
    
    @Insert("INSERT INTO `human_cloud`.`company` ( `business_reg_no`, `corpid`, `password`,`name`, `contact`, `email`, `owner`, `address`) "
            + "VALUES (#{businessRegNo}, #{corpid} ,#{password} , #{name}, #{contact}, #{email}, #{owner}, #{address})")
    int insertCorp(Corp corp);
}
