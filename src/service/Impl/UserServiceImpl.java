package service.Impl;

import dao.UserDao;
import entity.User;
import service.UserService;

import javax.jws.WebService;

@WebService
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();

    public int add(User user) throws Exception {
        return userDao.register(user);
    }

    public User queryUser(String name) {
        return userDao.queryUser(name);
    }

    public User login(String name, String password) {
        return userDao.login(name, password);
    }

}
