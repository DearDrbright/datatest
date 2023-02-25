package service;

import pojo.ServiceAgent;
import pojo.PageBean;

import java.util.List;

public interface ServiceAgentService {
    List<ServiceAgent> selectAll();

    //增
    void add(ServiceAgent sa);

    //删
    void deleteByServiceAgentNo(String sano);
    void deleteByServiceAgentNos(List<String> sanos);

    //改
    void update(ServiceAgent sa);


    //分页条件查询
    PageBean<ServiceAgent> selectByPageAndCondition(int currentPage, int pageSize, ServiceAgent sa);
}
