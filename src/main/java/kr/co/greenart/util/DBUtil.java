package kr.co.greenart.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class DBUtil {
	private static DataSource dataSource;
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		initDataSource();
		initSqlSessionFactory();
	}

	
	private static void initDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://192.168.0.41:3306/human_cloud");
		ds.setUsername("dev01");
		ds.setPassword("dev01");
		
		ds.setInitialSize(0); // 앱 시작시 0개의 커넥션 생성
		ds.setMaxTotal(8); // 최대 8개의 커넥션을 유지
		ds.setMaxIdle(8); // 유휴상태의 최대 커넥션 갯수
		ds.setMinIdle(0); // 유휴상태의 최소 커넥션 갯수
		
		dataSource = ds;
	}
	
	private static void initSqlSessionFactory() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public static void driverLoad() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}