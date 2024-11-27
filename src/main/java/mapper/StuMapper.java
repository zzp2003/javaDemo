package mapper;

import pojo.Stu;

public interface StuMapper {
    public Stu findStuById(int id);
     public void updateStu(Stu stu);
     public void deleteStu(int id);
}
