package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");//解决编码

        User user = userService.selectByUsername(username);
        boolean flag = true;
        if(user == null){
            flag = false;
        }
        response.getWriter().write(""+flag);//存在为true
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决编码

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        User u = userService.selectByUser(user1);
        boolean flag = true;
        if(u == null){//如果不存在
            flag = false;
        }
        if(flag){//登录成功
            response.setContentType("text/html;charset=UTF-8");

            String path = "base.html";//基础界面
            request.getRequestDispatcher(path).forward(request,response);

        }else{//登录失败
            response.setContentType("text/html;charset=UTF-8");

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/log_delayed.html");
        }
    }
}
