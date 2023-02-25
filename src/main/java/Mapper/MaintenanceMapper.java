package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Maintenance;

import java.util.List;

public interface MaintenanceMapper {
    @Select("select * from maintenance")
    List<Maintenance> selectAll();

    void add(Maintenance a);

    void update(Maintenance a);

    @Select("delete from maintenance where maintenanceNo = #{No}")
    void deleteByMaintenanceNo(String No);

    void deleteByMaintenanceNos(@Param("mnos")List<String> mnos);

    //分页条件查询
    List<Maintenance> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("m") Maintenance m);

    int selectTotalCountByCondition(Maintenance a);
}
