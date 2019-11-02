package hhuc.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * author:cenhelm
 * mybatis工具类
 */

public class MybatisUtils {
	private static final String FILE_CONFIG = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory ;
	private MybatisUtils() {}
	static {
		InputStream inputStream;
		try {
			//读取mybatis配置文件
			inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(FILE_CONFIG);
			//创建会话工程（连接工厂）
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取自动提交的会话
	 * @return
	 */
	public static SqlSession getSqlSessionAutoCommit() {
	SqlSession session=sqlSessionFactory.openSession(true);
	return session;
	} 
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
