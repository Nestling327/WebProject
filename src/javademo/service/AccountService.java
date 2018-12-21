package javademo.service;

import Vo.User;

public interface AccountService {
    /**
     * 验证用户
     * @param user
     */
    public boolean verify(User user);
    /**
     * 注册新用户
     * @param user
     */
    public boolean signin(User user);
}
