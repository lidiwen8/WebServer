package service;

import dao.UserDao;
import entity.User;



public interface UserService {

    public int add(User user) throws Exception;

    public User queryUser(String name);

    public User login(String name, String password);

}
