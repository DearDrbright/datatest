package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Status;

import java.util.List;

public interface StatusMapper {
    @Select("select * from status")
    List<Status> selectAll();

    void add(Status a);

    void update(Status a);

    @Select("delete from status where statusNo = #{No}")
    void deleteByStatusNo(String No);

    void deleteByStatusNos(@Param("Snos")List<String> Snos);

    //分页条件查询
    List<Status> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("s") Status s);

    int selectTotalCountByCondition(Status a);
}
