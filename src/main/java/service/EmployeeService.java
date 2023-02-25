package service;

import pojo.Employee;
import pojo.PageBean;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectAll();

    //增
    void add(Employee e);

    //删
    void deleteByEmployeeNo(String eno);
    void deleteByEmployeeNos(List<String> enos);

    //改
    void update(Employee e);


    //分页条件查询
    PageBean<Employee> selectByPageAndCondition(int currentPage, int pageSize, Employee e);
}
