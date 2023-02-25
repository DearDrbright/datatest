package service;

import pojo.Asset;
import pojo.PageBean;

import java.util.List;

public interface AssetService {
    //查
    List<Asset> selectAll();

    //增
    void add(Asset a);

    //删
    void deleteByAssetNo(String ano);
    void deleteByAssetNos(List<String> anos);

    //改
    void update(Asset a);

    //分页条件查询
    PageBean<Asset> selectByPageAndCondition(int currentPage, int pageSize, Asset a);
}
