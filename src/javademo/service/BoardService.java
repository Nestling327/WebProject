package javademo.service;

import Vo.Commend;

import java.util.List;

public interface
BoardService {
    /**
     * 查找所有的留言
     *
     * @return 留言的集合
     */
    List<Commend> findAllCommends();

    /**
     * 将留言组装成json
     * @param commends 留言的集合
     * @return json
     */
    String commendsToJson(List<Commend> commends);

    /**
     * 插入一条留言
     *
     * @param commend 留言
     * @return 成功与否
     */
    boolean insertContent(Commend commend);
}
