package javademo.Filter;

import Vo.User;
import javademo.service.Accountimpl;

import javax.jms.Session;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
@WebFilter(filterName = "LoginFilter",urlPatterns = "/commend")
public class LoginFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain){
        HttpServletRequest req1 = (HttpServletRequest)req;
        HttpServletResponse resp1 =(HttpServletResponse) resp;
        HttpSession session = req1.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        if(username==""||password==""){
            req1.setAttribute("statu",0);
            return;
        }else {
            User user = null;
            user.setUserid(username);
            user.setPassword(password);
            if(new Accountimpl().verify(user)){
                req1.setAttribute("statu",1);
                return;
            }else {
                req1.setAttribute("statu",0);
                return;
            }
        }
    }
}
