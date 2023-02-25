package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    @Select("select * from employee")
    List<Employee> selectAll();

    void add(Employee a);

    void update(Employee a);

    @Select("delete from employee where employeeNo = #{No}")
    void deleteByEmployeeNo(String No);

    void deleteByEmployeeNos(@Param("Enos")List<String> Enos);

    //分页条件查询
    List<Employee> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("e") Employee e);

    int selectTotalCountByCondition(Employee a);
}
