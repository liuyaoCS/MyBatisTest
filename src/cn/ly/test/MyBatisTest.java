package cn.ly.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ly.bean.User;

public class MyBatisTest {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		List<User> users=sqlSession.selectList("test.findUserByName", "ly");
		System.out.println(users.get(0).getName());
		sqlSession.close();
	}
//	@Test
//	public void testInsertUser() {
//
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		User user = new User();
//		user.setName("cx");
//		user.setSalary(1000);
//		user.setBirthday(new Date());
//		user.setResume("");
//		user.setPassword("123");
//		
//		try {
//			sqlSession.insert("test.insertUser", user);
//			// 需要提交事务
//			sqlSession.commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 关闭sqlSession
//			sqlSession.close();
//		}
//
//		System.out.println("用户的id=" + user.getId());
//
//	}

	@Test
	public void testUpdateUser() {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(3);
		user.setName("lm");

		try {
			sqlSession.update("test.updateUser", user);
			// 需要提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}

		System.out.println("用户的id=" + user.getId());

	}
}
