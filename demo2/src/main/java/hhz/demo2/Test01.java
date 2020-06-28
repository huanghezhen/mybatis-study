package hhz.demo2;

import hhz.demo2.mapper.BlogMapper;
import hhz.demo2.model.Blog;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName: Test01
 * @Description:
 * @Author: huanghz
 * @Date: 2020/5/26 16:16
 */
public class Test01 {
    public static void main(String[] args) {
        PooledDataSourceFactory pooledDataSource = new PooledDataSourceFactory();
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://192.168.2.11:3306/bud_test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        pooledDataSource.setProperties(properties);
        DataSource dataSource = pooledDataSource.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);
        System.out.println(blog);
    }
}
