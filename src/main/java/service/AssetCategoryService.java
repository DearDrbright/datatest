package service;

import pojo.AssetCategory;
import pojo.PageBean;

import java.util.List;

public interface AssetCategoryService {
    //查
    List<AssetCategory> selectAll();

    //增
    void add(AssetCategory a);

    //删
    void deleteByAssetCategoryNo(String ano);
    void deleteByAssetCategoryNos(List<String> anos);

    //改
    void update(AssetCategory a);

    //分页查询
    //currentPage：当前页码      pageSize：每页展示条数
    PageBean<AssetCategory> selectByPage(int currentPage, int pageSize);

    //分页条件查询
    PageBean<AssetCategory> selectByPageAndCondition(int currentPage, int pageSize, AssetCategory a);
}
