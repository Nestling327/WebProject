package javademo.Servlet;

import Vo.Commend;
import javademo.service.Borderimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@WebServlet("/commend")
public class InfoServlet {
    //service的单例
    Borderimpl messageBoardService;

    /**
     * 重写初始化的方法 为service赋值
     */

    public void init() {
        messageBoardService = new Borderimpl();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Commend> messageList = messageBoardService.findAllCommends();
        String res = messageBoardService.commendsToJson(messageList);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        resp.getOutputStream()
                )
        );
        int a = (int) req.getAttribute("statu");
        String str = null;
        if(a==0){
            str = "没有登录,只能查看";
        }else
        {
            str = "欢迎"+req.getAttribute("username")+"光临";
        }
        writer.write(str+res);
        writer.flush();
        writer.close();
    }
}
