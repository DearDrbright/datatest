package web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")//过滤器拦截资源的路径
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行前，对request处理
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        //放行跟登录，注册相关的
        String[] urls = {"/login", "login.html", "/register","register.html","/imgs/", "/css/"};
        String url = req.getRequestURL().toString();
        for(String u : urls){
            if(url.equals(u)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        //判断session是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user != null){//已登录
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            //放行后，对response处理
        }else{//未登录
            //跳转登陆界面
            req.setAttribute("fl_log_msg","您尚未登录");
            req.getRequestDispatcher("login.html").forward(req,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
