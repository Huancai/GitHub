package com.shop.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public static SqlSessionFactory getSqlSessionFactory() {

		String filename = "mybatis-db-config.xml";
		InputStream is = MyBatisUtil.class.getClassLoader()
				.getResourceAsStream(filename);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}

	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}

	public static SqlSession getSqlSession(boolean isAutoCommit) {
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
}
