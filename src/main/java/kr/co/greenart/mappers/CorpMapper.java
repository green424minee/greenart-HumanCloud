package kr.co.greenart.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.green.corp.Corp;

public interface CorpMapper {
    @Select("SELECT * FROM company")
    @Results(id = "corpResults", value = {
            @Result(column = "id", property = "id", id = true)
            , @Result(column = "corpid", property = "corpid")
            , @Result(column = "password", property = "password")
            , @Result(column = "business_reg_no", property = "business_reg_no")
            , @Result(column = "image", property = "image")
            , @Result(column = "name", property = "name")
            , @Result(column = "description", property = "description")
            , @Result(column = "contact", property = "contact")
            , @Result(column = "email", property = "email")
            , @Result(column = "owner", property = "owner")
            , @Result(column = "est_date", property = "estDate")
            , @Result(column = "website", property = "website")
            , @Result(column = "emp_count", property = "emp_count")
            , @Result(column = "sales", property = "sales")
            , @Result(column = "address", property = "address")
    })
    List<Corp> selectAll();
    
    @Insert("INSERT INTO company (business_reg_no, corpid, password, name, contact, email, owner, address) "
            + "VALUES (#{business_reg_no}, #{corpid}, #{password}, #{name}, #{contact}, #{email}, #{owner}, #{address})")
    int insertCorp(Corp corp);
    
    @Select("SELECT id, corpid, password, business_reg_no, name, description, contact, email, website, emp_count, sales, owner, address FROM company WHERE corpid = #{corpId}")
    @Results(id = "corpResult", value = {
            @Result(column = "id", property = "id", id = true)
            , @Result(column = "corpid", property = "corpid")
            , @Result(column = "password", property = "password")
            , @Result(column = "business_reg_no", property = "business_reg_no")
            , @Result(column = "name", property = "name")
            , @Result(column = "description", property = "description")
            , @Result(column = "contact", property = "contact")
            , @Result(column = "email", property = "email")
            , @Result(column = "website", property = "website")
            , @Result(column = "emp_count", property = "emp_count")
            , @Result(column = "sales", property = "sales")
            , @Result(column = "owner", property = "owner")
            , @Result(column = "address", property = "address")
    })
    Corp selectById(String corpId);
    
    @Update("UPDATE company SET " +
            "name = #{name}, " +
            "business_reg_no = #{business_reg_no}, " +
            "description = #{description}, " +
            "contact = #{contact}, " +
            "email = #{email}, " +
            "owner = #{owner}, " +
            "website = #{website}, " +
            "emp_count = #{emp_count}, " +
            "sales = #{sales}, " +
            "address = #{address}, " +
            "image = #{image} " +
            "WHERE corpid = #{corpid}")
    int updateCorp(Corp corp);
    
    @Select("SELECT id, corpid, password, business_reg_no, name, contact, email, owner, address FROM company WHERE id = #{id}")
    @ResultMap("corpResult")
	Corp selectByIdNo(int id);
    
    @Insert("INSERT INTO job_offer (user_id, company_id) VALUES (#{user_id}, #{company_id})")
	int insertOffer(@Param("user_id") int user_id,
					@Param("company_id") int company_id);
}
