package service;

import pojo.PageBean;
import pojo.Status;

import java.util.List;

public interface StatusService {
        List<Status> selectAll();

        //增
        void add(Status s);

        //删
        void deleteByStatusNo(String sno);
        void deleteByStatusNos(List<String> snos);

        //改
        void update(Status s);


        //分页条件查询
        PageBean<Status> selectByPageAndCondition(int currentPage, int pageSize, Status s);

}
