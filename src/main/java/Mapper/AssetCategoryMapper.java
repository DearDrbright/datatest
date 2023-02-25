package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.AssetCategory;

import java.util.List;

public interface AssetCategoryMapper {

    @Select("select * from assetcategory")
//    @ResultMap("")
    List<AssetCategory> selectAll();

    @Select("select * from assetcategory where assetCategoryNo = #{No}")
    AssetCategory selectByAssetCategoryNo(String No);

    void add(AssetCategory a);

    void update(AssetCategory a);

    @Select("delete from assetcategory where assetCategoryNo = #{No}")
    void deleteByAssetCategoryNo(String No);

    void deleteByAssetCategoryNos(@Param("Anos")List<String> Anos);

    //分页查询
    @Select("select * from assetcategory limit #{begin}, #{size}")
    List<AssetCategory> selectByPage(@Param("begin") int begin, @Param("size") int size);
    //查询总记录数
    @Select("select count(*) from assetcategory")
    int selectTotalCount();

    //分页条件查询
    List<AssetCategory> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("a") AssetCategory a);

    int selectTotalCountByCondition(AssetCategory a);
}
