package javademo.service;

import Vo.User;
import javademo.DAO.UserDAO;
import javademo.DAO.UserDAOimpl;

public class Accountimpl implements AccountService {
    @Override
    public boolean verify(User user) {
        UserDAO userDAO = new UserDAOimpl();
        boolean flag = userDAO.findLogin(user);
        return flag;
    }

    @Override
    public boolean signin(User user) {
        UserDAO userDAO = new UserDAOimpl();
        boolean flag = userDAO.signin(user);
        return flag;
    }
}
