package com.shop.test;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.shop.model.User;
import com.shop.util.MyBatisUtil;

public class TestByXMLMapper {

	@Test
	public void testAdd() {
		SqlSession session = MyBatisUtil.getSqlSession();

		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId(i + 1);
			user.setUsername("huancai-" + i);
			user.setPassword("123456");
			user.setAddress("adress-" + i);
			user.setStatus(i % 2);
			session.insert("com.shop.model.UserMapper.add", user);
		}
		session.commit();
		session.close();
	}

	@Test
	public void testQryAll() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		List<User> list = session.selectList("com.shop.model.UserMapper.qryAll");
		Iterator<User> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.err.println(iterator.next().toString());
		}
	}
}
