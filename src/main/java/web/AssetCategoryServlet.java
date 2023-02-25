package web;

import com.alibaba.fastjson.JSON;
import pojo.AssetCategory;
import pojo.PageBean;
import service.AssetCategoryService;
import service.impl.AssetCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/AssetCategory/*")
public class AssetCategoryServlet extends BaseServlet{
    private AssetCategoryService assetCategoryService = new AssetCategoryServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AssetCategory> assetCategories = assetCategoryService.selectAll();
        String jsonString = JSON.toJSONString(assetCategories);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader va = request.getReader();
        String params = va.readLine();

        //转为AssetCategory对象
        AssetCategory assetCategory = JSON.parseObject(params,AssetCategory.class);

        //调用service添加
        assetCategoryService.add(assetCategory);

        //响应成功
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader as = request.getReader();
        String params = as.readLine();

        AssetCategory assetCategory = JSON.parseObject(params,AssetCategory.class);

        assetCategoryService.update(assetCategory);

        response.getWriter().write("success");
    }

    public void deleteByAssetCategoryNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader as = request.getReader();
        String params = as.readLine();
        //转为相应对象
        String ano = JSON.parseObject(params, String.class);

        assetCategoryService.deleteByAssetCategoryNo(ano);

        response.getWriter().write("success");
    }
    public void deleteByAssetCategoryNos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        BufferedReader as = request.getReader();
        String params = as.readLine();

        //转为相应对象
        List<String> asnos = JSON.parseObject(params,List.class);

        //调用service
        assetCategoryService.deleteByAssetCategoryNos(asnos);

        //响应成功
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<AssetCategory> pageBean = assetCategoryService.selectByPage(currentPage, pageSize);

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
        BufferedReader as = request.getReader();
        String params = as.readLine();//json字符串

        //转为相应对象
        AssetCategory ass = JSON.parseObject(params, AssetCategory.class);

        PageBean<AssetCategory> pageBean = assetCategoryService.selectByPageAndCondition(currentPage, pageSize, ass);

        String json = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset = utf-8");
        response.getWriter().write(json);
    }
}
