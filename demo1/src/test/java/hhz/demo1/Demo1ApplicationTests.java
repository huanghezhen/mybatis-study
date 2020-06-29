package hhz.demo1;

import hhz.demo1.dao.MyMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Demo1ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	void test1() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MyMapper mapper = session.getMapper(MyMapper.class);
			int count = mapper.count();
			System.out.println(count);
		}
	}

}
