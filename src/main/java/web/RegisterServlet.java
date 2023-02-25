package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = userService.selectByUsername(username);
        boolean flag = true;
        if(user == null){
            flag = false;
        }
        response.getWriter().write(""+flag);//存在为true
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user2 = new User();
        user2.setUsername(username);
        user2.setPassword(password);

        boolean flag = userService.register(user2);

        String register_msg = "";
        if(flag){//注册成功
            register_msg = "注册成功，请登录！";
            request.setAttribute("register_msg",register_msg);
            request.getRequestDispatcher("log_delayed.html").forward(request,response);
        }else{//注册失败
            register_msg = "用户名已存在";
            request.setAttribute("register_msg",register_msg);
            request.getRequestDispatcher("reg_delayed.html").forward(request,response);
        }
    }
}
