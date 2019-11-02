package hhuc.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * author:cenhelm
 * mybatis������
 */

public class MybatisUtils {
	private static final String FILE_CONFIG = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory ;
	private MybatisUtils() {}
	static {
		InputStream inputStream;
		try {
			//��ȡmybatis�����ļ�
			inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(FILE_CONFIG);
			//�����Ự���̣����ӹ�����
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�Զ��ύ�ĻỰ
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
