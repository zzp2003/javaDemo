package mapper;


import pojo.User;

public interface UserMapper {
    public User findUser(int id);
    public int addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
