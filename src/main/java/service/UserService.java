package service;

import pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll();
    public User selectByUser(User user);
    public User selectByUsername(String username);
    public boolean register(User user);
}
