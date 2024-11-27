package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Stu;

import java.io.InputStream;

public class StuMapperTest {
    SqlSession session = null;
    StuMapper stuMapper = null;
    @Before
    public void setUp() throws Exception {
        InputStream is = null;
        is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
         session = sqlSessionFactory.openSession();
         stuMapper = session.getMapper(StuMapper.class);

    }
    @Test
    public void findStuById() {
        Stu stu = stuMapper.findStuById(4);
        System.out.println(stu.getString());
        session.close();
    }
    @Test
    public void updateStu() {
        Stu stu = new Stu();
        stu.setId(4);
        stu.setName("蜘蛛侠");
        stu.setGrade("计算机1225");
        stuMapper.updateStu(stu);
        session.commit();
        session.close();
    }
@Test
    public void deleteStu() {

        stuMapper.deleteStu(4);
        session.commit();
        System.out.println("Student with ID 4 deleted.");
        session.close();
    }
}
