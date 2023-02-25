package web;

import com.alibaba.fastjson.JSON;
import pojo.Asset;
import pojo.Asset;
import pojo.PageBean;
import service.AssetService;
import service.impl.AssetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Asset/*")
public class AssetServlet extends BaseServlet{
    private AssetService assetService = new AssetServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Asset> assetCategories = assetService.selectAll();
        String jsonString = JSON.toJSONString(assetCategories);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader va = request.getReader();
        String params = va.readLine();

        //转为Asset对象
        Asset asset = JSON.parseObject(params,Asset.class);

        //调用service添加
        assetService.add(asset);

        //响应成功
        response.getWriter().write("success");
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader as = request.getReader();
        String params = as.readLine();

        Asset asset = JSON.parseObject(params,Asset.class);

        assetService.update(asset);

        response.getWriter().write("success");
    }
    public void deleteByAssetNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader as = request.getReader();
        String params = as.readLine();
        //转为相应对象
        String ano = JSON.parseObject(params, String.class);

        assetService.deleteByAssetNo(ano);

        response.getWriter().write("success");
    }
    public void deleteByAssetNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader as = request.getReader();
        String params = as.readLine();

        //转为相应对象
        List<String> asnos = JSON.parseObject(params,List.class);

        //调用service
        assetService.deleteByAssetNos(asnos);

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
        BufferedReader as = request.getReader();
        String params = as.readLine();//json字符串

        //转为相应对象
        Asset ass = JSON.parseObject(params, Asset.class);

        PageBean<Asset> pageBean = assetService.selectByPageAndCondition(currentPage, pageSize, ass);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
}
