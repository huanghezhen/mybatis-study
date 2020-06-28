package hhz.demo1;

import hhz.demo1.mapper.MyMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}


	@Test
	public void test1() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MyMapper mapper = session.getMapper(MyMapper.class);
			int count = mapper.count();
			System.out.println(count);
		}
	}


	@Test
	public void test2() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(MyMapper.class);
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(configuration);
		try (SqlSession session = sqlSession.openSession()) {
			MyMapper mapper = session.getMapper(MyMapper.class);
			int count = mapper.count();
			System.out.println(count);
		}
	}

}
