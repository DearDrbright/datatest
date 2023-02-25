package web;

import com.alibaba.fastjson.JSON;
import pojo.Maintenance;
import pojo.PageBean;
import service.MaintenanceService;
import service.impl.MaintenanceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Maintenance/*")
public class MaintenanceServlet extends BaseServlet{
    private MaintenanceService maintenanceService = new MaintenanceServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Maintenance> maintenances = maintenanceService.selectAll();
        String jsonString = JSON.toJSONString(maintenances);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为Maintenance对象
        Maintenance maintenance = JSON.parseObject(params,Maintenance.class);

        //调用service添加
        maintenanceService.add(maintenance);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader st = request.getReader();
        String params = st.readLine();

        Maintenance maintenance = JSON.parseObject(params,Maintenance.class);

        maintenanceService.update(maintenance);

        response.getWriter().write("success");
    }

    public void deleteByMaintenanceNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();
        //转为相应对象
        String eno = JSON.parseObject(params, String.class);

        maintenanceService.deleteByMaintenanceNo(eno);

        response.getWriter().write("success");
    }
    public void deleteByMaintenanceNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为相应对象
        List<String> enos = JSON.parseObject(params,List.class);

        //调用service
        maintenanceService.deleteByMaintenanceNos(enos);

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
        Maintenance maintenance = JSON.parseObject(params, Maintenance.class);

        PageBean<Maintenance> pageBean = maintenanceService.selectByPageAndCondition(currentPage, pageSize, maintenance);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
}
