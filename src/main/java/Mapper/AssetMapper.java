package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Asset;

import java.util.List;

public interface AssetMapper {
    @Select("select * from asset")
//    @ResultMap("")
    List<Asset> selectAll();

    void add(Asset a);

    void update(Asset a);

    @Select("delete from asset where assetNo = #{No}")
    void deleteByAssetNo(String No);

    void deleteByAssetNos(@Param("Anos")List<String> Anos);

    //分页条件查询
    List<Asset> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("a") Asset a);

    int selectTotalCountByCondition(Asset a);
}
