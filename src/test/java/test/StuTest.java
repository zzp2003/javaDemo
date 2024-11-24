package test;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Stu;

public class StuTest {

    @Test
    public void findStuById()
    {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sqlSessionFactory.openSession();
            Stu stu = session.selectOne("mapper.Stu.findStuById",2);
            System.out.println("name:"+stu.getName()+" grade:"+stu.getGrade());
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addStu()
    {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sqlSessionFactory.openSession();
            Stu stu = new Stu();
            stu.setId(4);
            stu.setName("xiaoming");
            stu.setGrade("计算机1226");
            int nRow = session.insert("pojo.Stu.addStu",stu);
            session.commit();
            if(nRow>0)
                System.out.println("数据插入成功");
            else
                System.out.println("数据插入失败");
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
