package web;

import com.alibaba.fastjson.JSON;
import pojo.PageBean;
import pojo.Valuation;
import service.ValuationService;
import service.impl.ValuationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Valuation/*")
public class ValuationServlet extends BaseServlet{
    private ValuationService valuationService = new ValuationServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Valuation> valuations = valuationService.selectAll();
        String jsonString = JSON.toJSONString(valuations);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader va = request.getReader();
        String params = va.readLine();

        //转为valuation对象
        Valuation valuation = JSON.parseObject(params,Valuation.class);

        //调用service添加
        valuationService.add(valuation);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader va = request.getReader();
        String params = va.readLine();

        Valuation valuation = JSON.parseObject(params,Valuation.class);

        valuationService.update(valuation);

        response.getWriter().write("success");
    }

    public void deleteByValuationNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader va = request.getReader();
        String params = va.readLine();
//        System.out.println(params);
        //转为相应对象
        String vno = JSON.parseObject(params, String.class);
//        System.out.println(vno);

        valuationService.deleteByValuationNo(vno);

        response.getWriter().write("success");
    }
    public void deleteByValuationNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader va = request.getReader();
        String params = va.readLine();

        //转为相应对象
        List<String> vnos = JSON.parseObject(params,List.class);

        //调用service
        valuationService.deleteByValuationNos(vnos);

        //响应成功
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Valuation> pageBean = valuationService.selectByPage(currentPage, pageSize);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从url中获取
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取对应的查询条件对象
        BufferedReader va = request.getReader();
        String params = va.readLine();//json字符串

        //转为相应对象
        Valuation v = JSON.parseObject(params, Valuation.class);

//        System.out.println(v);
        PageBean<Valuation> pageBean = valuationService.selectByPageAndCondition(currentPage, pageSize, v);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
}