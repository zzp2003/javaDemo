package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Usertest {
    @Test
    public void findUser()
    {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sqlSessionFactory.openSession();
            User user =session.selectOne("mapper.User.findUser",1);
            System.out.println("username"+user.getUsername()+"password"+user.getPassword()+"email"+user.getEmail()+"phone"+user.getPhone() );
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@Test
    public void findUserByUsernameAndPassword() {
        InputStream is = null;
        try {
            // 读取 MyBatis 配置文件
            is = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 打开 SqlSession
            SqlSession session = sqlSessionFactory.openSession();

            // 构建查询参数
            Map<String, Object> params = new HashMap<>();
            params.put("username", "xiaohong"); // 替换为实际用户名
            params.put("password", "password123"); // 替换为实际密码

            // 执行查询
            User user = session.selectOne("mapper.User.findUserByUsernameAndPassword", params);

            // 判断查询结果
            if (user != null) {
                System.out.println("查询成功：");
                System.out.println("用户名：" + user.getUsername());
                System.out.println("密码：" + user.getPassword());
                System.out.println("邮箱：" + user.getEmail());
                System.out.println("电话：" + user.getPhone());
            } else {
                System.out.println("未找到匹配的用户信息");
            }

            // 关闭 SqlSession
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@Test
    public void addUser() {
        InputStream is = null;
        try {
            // 读取 MyBatis 配置文件
            is = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 打开 SqlSession
            SqlSession session = sqlSessionFactory.openSession();

            // 创建 User 对象并设置其属性
            User user = new User();
            user.setId(2);  // 假设 ID 为 5（通常使用自增主键时不需要设置 ID）
            user.setUsername("xiaohong");
            user.setPassword("password123");
            user.setEmail("xiaohong@example.com");
            user.setPhone("13512345678");

            // 执行插入操作
            int nRow = session.insert("mapper.User.addUser", user);
            // 提交事务
            session.commit();

            // 判断插入是否成功
            if (nRow > 0) {
                System.out.println("数据插入成功");
            } else {
                System.out.println("数据插入失败");
            }

            // 关闭 SqlSession
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
