package web;

import com.alibaba.fastjson.JSON;
import pojo.PageBean;
import pojo.Status;
import service.StatusService;
import service.impl.StatusServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Status/*")
public class StatusServlet extends BaseServlet{
    private StatusService statusService = new StatusServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Status> statuses = statusService.selectAll();
        String jsonString = JSON.toJSONString(statuses);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为Status对象
        Status status = JSON.parseObject(params,Status.class);

        //调用service添加
        statusService.add(status);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader st = request.getReader();
        String params = st.readLine();

        Status Status = JSON.parseObject(params,Status.class);

        statusService.update(Status);

        response.getWriter().write("success");
    }

    public void deleteByStatusNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();
        //转为相应对象
        String sno = JSON.parseObject(params, String.class);

        statusService.deleteByStatusNo(sno);

        response.getWriter().write("success");
    }
    public void deleteByStatusNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为相应对象
        List<String> snos = JSON.parseObject(params,List.class);

        //调用service
        statusService.deleteByStatusNos(snos);

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
        Status s = JSON.parseObject(params, Status.class);

        PageBean<Status> pageBean = statusService.selectByPageAndCondition(currentPage, pageSize, s);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }

}
