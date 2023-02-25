package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Valuation;

import java.util.List;

public interface ValuationMapper {
    @Select("select * from valuation")
    List<Valuation> selectAll();

    @Select("select * from valuation where valuationNo = #{No}")
    Valuation selectByValuationNo(String No);

    void add(Valuation v);

    void update(Valuation v);

    @Select("delete from valuation where valuationNo = #{No}")
    void deleteByValuationNo(String valuationNo);

    void deleteByValuationNos(@Param("Vnos")List<String> Vnos);

    //分页查询
    @Select("select * from valuation limit #{begin}, #{size}")
    List<Valuation> selectByPage(@Param("begin") int begin, @Param("size") int size);
    //查询总记录数
    @Select("select count(*) from valuation")
    int selectTotalCount();

    //分页条件查询
    List<Valuation> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("v") Valuation v);

    int selectTotalCountByCondition(Valuation v);
}
