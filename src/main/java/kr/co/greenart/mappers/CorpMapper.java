package kr.co.greenart.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import kr.co.green.corp.Corp;

public interface CorpMapper {
    @Select("SELECT * FROM company")
    @Results(id = "corpResults", value = {
            @Result(column = "id", property = "id", id = true)
            , @Result(column = "corpid", property = "corpid")
            , @Result(column = "password", property = "password")
            , @Result(column = "business_reg_no", property = "businessRegNo")
            , @Result(column = "image", property = "image")
            , @Result(column = "name", property = "name")
            , @Result(column = "description", property = "description")
            , @Result(column = "contact", property = "contact")
            , @Result(column = "email", property = "email")
            , @Result(column = "owner", property = "owner")
            , @Result(column = "est_date", property = "estDate")
            , @Result(column = "website", property = "website")
            , @Result(column = "emp_count", property = "empCount")
            , @Result(column = "sales", property = "sales")
            , @Result(column = "address", property = "address")
    })
    List<Corp> selectAll();
    
    @Insert("INSERT INTO company (business_reg_no, corpid, password, name, contact, email, owner, address) "
            + "VALUES (#{businessRegNo}, #{corpid}, #{password}, #{name}, #{contact}, #{email}, #{owner}, #{address})")
    int insertCorp(Corp corp);
    
    @Select("SELECT * FROM company WHERE corpid = #{corpId}")
    @Results(id = "corpResult", value = {
            @Result(column = "id", property = "id", id = true)
            , @Result(column = "corpid", property = "corpid")
            , @Result(column = "password", property = "password")
            , @Result(column = "contact", property = "contact")
            , @Result(column = "email", property = "address")
            , @Result(column = "owner", property = "owner")
            , @Result(column = "address", property = "address")
    })
    
    Corp selectById(String corpId);
}
