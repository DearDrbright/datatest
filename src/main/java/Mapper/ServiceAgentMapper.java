package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.ServiceAgent;

import java.util.List;

public interface ServiceAgentMapper {
    @Select("select * from serviceagent")
    List<ServiceAgent> selectAll();

    void add(ServiceAgent sa);

    void update(ServiceAgent sa);

    @Select("delete from serviceagent where agentNo = #{No}")
    void deleteByServiceAgentNo(String No);

    void deleteByServiceAgentNos(@Param("sanos")List<String> sanos);

    //分页条件查询
    List<ServiceAgent> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("sa") ServiceAgent sa);

    int selectTotalCountByCondition(ServiceAgent sa);
}
