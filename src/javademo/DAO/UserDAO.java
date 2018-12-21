package javademo.DAO;

import Vo.Commend;
import Vo.User;

import java.util.List;

public interface UserDAO {
    /**
     * 插入评论
     * @param commend 传入VO对象
     * @return 插入操作结果
     */
    public boolean insert(Commend commend);
    /**
     * 返回子评论
     * @param pid 传入pid
     * @return 返回评论列表
     */
    public List<Commend> findchild(int pid);
    /**
     * 用户登录验证
     * @param user 传入VO对象
     * @return 验证的操作结果
     */
    public boolean findLogin(User user);
    /**
     * 用户注册
     * @param user 传入VO
     * @return 结果
     */
    public boolean signin(User user);
}
