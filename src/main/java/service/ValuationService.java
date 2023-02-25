package service;

import pojo.PageBean;
import pojo.Valuation;

import java.util.List;

public interface ValuationService {
    //查
    List<Valuation> selectAll();

    //增
    void add(Valuation v);

    //删
    void deleteByValuationNo(String vno);
    void deleteByValuationNos(List<String> vnos);

    //改
    void update(Valuation v);

    //分页查询
    //currentPage：当前页码      pageSize：每页展示条数
    PageBean<Valuation> selectByPage(int currentPage, int pageSize);

    //分页条件查询
    PageBean<Valuation> selectByPageAndCondition(int currentPage, int pageSize, Valuation v);

}
