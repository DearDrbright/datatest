package web;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import pojo.PageBean;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Employee/*")
public class EmployeeServlet extends BaseServlet{
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.selectAll();
        String jsonString = JSON.toJSONString(employees);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为Employee对象
        Employee employee = JSON.parseObject(params,Employee.class);

        //调用service添加
        employeeService.add(employee);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader st = request.getReader();
        String params = st.readLine();

        Employee employee = JSON.parseObject(params,Employee.class);

        employeeService.update(employee);

        response.getWriter().write("success");
    }

    public void deleteByEmployeeNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();
        //转为相应对象
        String eno = JSON.parseObject(params, String.class);

        employeeService.deleteByEmployeeNo(eno);

        response.getWriter().write("success");
    }
    public void deleteByEmployeeNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader st = request.getReader();
        String params = st.readLine();

        //转为相应对象
        List<String> enos = JSON.parseObject(params,List.class);

        //调用service
        employeeService.deleteByEmployeeNos(enos);

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
        Employee e = JSON.parseObject(params, Employee.class);

        PageBean<Employee> pageBean = employeeService.selectByPageAndCondition(currentPage, pageSize, e);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
}
