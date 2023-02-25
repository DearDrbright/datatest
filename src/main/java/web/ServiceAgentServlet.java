package web;

import com.alibaba.fastjson.JSON;
import pojo.PageBean;
import pojo.ServiceAgent;
import service.ServiceAgentService;
import service.impl.ServiceAgentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServiceAgent/*")
public class ServiceAgentServlet extends BaseServlet{
    private ServiceAgentService serviceAgentService = new ServiceAgentServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceAgent> serviceAgents = serviceAgentService.selectAll();
        String jsonString = JSON.toJSONString(serviceAgents);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为ServiceAgent对象
        ServiceAgent serviceAgent = JSON.parseObject(params,ServiceAgent.class);

        //调用service添加
        serviceAgentService.add(serviceAgent);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader st = request.getReader();
        String params = st.readLine();

        ServiceAgent serviceAgent = JSON.parseObject(params,ServiceAgent.class);

        serviceAgentService.update(serviceAgent);

        response.getWriter().write("success");
    }

    public void deleteByServiceAgentNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();
        //转为相应对象
        String sano = JSON.parseObject(params, String.class);

        serviceAgentService.deleteByServiceAgentNo(sano);

        response.getWriter().write("success");
    }
    public void deleteByServiceAgentNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为相应对象
        List<String> sanos = JSON.parseObject(params,List.class);

        //调用service
        serviceAgentService.deleteByServiceAgentNos(sanos);

        //响应成功
        response.getWriter().write("success");
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从url中获取
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取对应的查询条件对象
        BufferedReader st = request.getReader();
        String params = st.readLine();//json字符串

        //转为相应对象
        ServiceAgent sa = JSON.parseObject(params, ServiceAgent.class);

        PageBean<ServiceAgent> pageBean = serviceAgentService.selectByPageAndCondition(currentPage, pageSize, sa);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }

}
