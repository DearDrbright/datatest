package service;

import pojo.Maintenance;
import pojo.PageBean;

import java.util.List;

public interface MaintenanceService {
    List<Maintenance> selectAll();

    //增
    void add(Maintenance m);

    //删
    void deleteByMaintenanceNo(String mno);
    void deleteByMaintenanceNos(List<String> mnos);

    //改
    void update(Maintenance m);


    //分页条件查询
    PageBean<Maintenance> selectByPageAndCondition(int currentPage, int pageSize, Maintenance m);
}
