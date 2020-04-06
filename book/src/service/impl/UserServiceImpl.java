package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userdao=new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userdao.queryUserByUsername(username)!=null){
            return true;
        }
        return false;
    }
}