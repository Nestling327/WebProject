package javademo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javademo.DButil.Spider;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        String value = req.getPathInfo();
        value = value.substring(1,value.length());
        String html = null;
        String url = "http://jwzx.cqupt.edu.cn/kebiao/kb_stu.php?xh=";
        html = Spider.httpRequest(url+value);
        System.out.println(html);
        List<Class> classes = Spider.CreatTable(html);
        Gson gson = new Gson();
        int i=0;
        while (!classes.isEmpty()){
            String json = gson.toJson(classes.remove(i));
            PrintWriter out = resp.getWriter();
            out.print(value);
            out.print(json);
            i++;
        }


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doPost(req,resp);
    }

}
