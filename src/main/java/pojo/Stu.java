package pojo;

public class Stu {
    private int id;
    private String name;
    private String grade;
    public String getString() {
        return "id:" + id + ",name:" + name + ",grade:" + grade;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }

}
