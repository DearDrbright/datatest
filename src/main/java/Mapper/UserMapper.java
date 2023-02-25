package Mapper;

import java.util.List;
import pojo.User;

public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);
    User selectByUsername(String username);
    User selectByUser(User user);
    void add(User user);
}
