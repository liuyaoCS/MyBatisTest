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
import cn.ly.mapper.UserMapper;

public class MyBatisMapperTest {
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
		//create proxy
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.findUserById(1);
		System.out.println(user.getName());
		
		sqlSession.close();
	}
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> users=userMapper.findUserByName("ly");
		System.out.println(users.get(0).getName());
		
		sqlSession.close();
	}
	
}
