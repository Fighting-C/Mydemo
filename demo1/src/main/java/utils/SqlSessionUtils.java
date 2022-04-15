package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;




public class SqlSessionUtils {
    private static String recourse="Mybatis_conf.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    public static SqlSessionFactory getSqlSessionFactory() {
        try {
            InputStream is = Resources.getResourceAsStream(recourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

//    public static void close() {
//        SqlSession session = threadLocal.get();
//        if (session != null) {
//            session.close();
//            threadLocal.set(null);
//        }
//    }
}