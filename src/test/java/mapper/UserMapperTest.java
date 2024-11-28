package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.User;

import java.io.InputStream;

public class UserMapperTest {
    SqlSession session = null;
    UserMapper userMapper = null;
    @Before
    public void setUp() throws Exception {
        InputStream is = null;
        is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }
        @Test
        public void findUser(){
            User user = userMapper.findUser(5);
            System.out.println(user.getString());
            session.close();
        }
@Test
        public void addUser(){
        User user = new User();
            user.setId(3);
            user.setUsername("蜘蛛侠12");
            user.setPassword("1234522");
            user.setEmail("12345655@qq.com");
            user.setPhone("12345678");
            userMapper.addUser(user);
            session.commit();
            System.out.println("success add user");
            session.close();
        }
        @Test
        public void updateUser() {
            User user = new User();
            user.setId(3);
            user.setUsername("蜘蛛侠");
            user.setPassword("123456");
            user.setEmail("123456@qq.com");
            user.setPhone("12345678");
            userMapper.updateUser(user);
            session.commit();
            System.out.println("success update user");
            session.close();
        }
        @Test
    public void deleteUser() {

        userMapper.deleteUser(1);
        session.commit();
        System.out.println("success delete");
        session.close();
    }
    }

