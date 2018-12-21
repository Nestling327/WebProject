package javademo.service;

import Vo.Commend;
import com.google.gson.Gson;
import javademo.DAO.UserDAO;
import javademo.DAO.UserDAOimpl;

import java.util.List;

public class Borderimpl implements BoardService {

    public List<Commend> findchild(Commend commend){
        UserDAO userDAO = new UserDAOimpl();
        List<Commend> list = userDAO.findchild(commend.getId());

        //遍历它的子节点 然后递归找每条评论下的评论 即节点的子节点
        for (Commend com : list) {
            //递归找这条评论的节点 然后赋值
            List<Commend> childList = userDAO.findchild(com.getId());
            commend.setChildcom(childList);
        }
        return list;
    }
    @Override
    public List<Commend> findAllCommends() {
        UserDAO userDAO = new UserDAOimpl();
        List<Commend> list = userDAO.findchild(0);
        for (Commend commend : list){
            List<Commend> list1 = this.findchild(commend);
            commend.setChildcom(list1);
        }
        return list;
    }

    @Override
    public String commendsToJson(List<Commend> commends) {
        StringBuffer stringBuffer = new StringBuffer();
        String json = null;
        Gson gson = new Gson();
        for (Commend commend : commends){
            stringBuffer.append(gson.toJson(commend));
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean insertContent(Commend commend) {
        boolean flag = false;
        UserDAO  userDAO=new UserDAOimpl();
        if (commend.getUsername()!= null && commend.getInfo()!=null){
            userDAO.insert(commend);
            flag = true;
        }
        return flag;
    }
}
