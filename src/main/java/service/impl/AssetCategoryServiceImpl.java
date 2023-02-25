package service.impl;

import Mapper.AssetCategoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.AssetCategory;
import pojo.PageBean;
import service.AssetCategoryService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class AssetCategoryServiceImpl implements AssetCategoryService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<AssetCategory> selectAll() {
        SqlSession sqlSession = factory.openSession();

        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        List<AssetCategory> assetCategories = mapper.selectAll();

        sqlSession.close();

        return assetCategories;
    }

    @Override
    public void add(AssetCategory a) {
        SqlSession sqlSession = factory.openSession();

        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        mapper.add(a);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByAssetCategoryNo(String ano) {

        SqlSession sqlSession = factory.openSession();

        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        mapper.deleteByAssetCategoryNo(ano);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByAssetCategoryNos(List<String> anos) {

        SqlSession sqlSession = factory.openSession();

        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        mapper.deleteByAssetCategoryNos(anos);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void update(AssetCategory a) {

        SqlSession sqlSession = factory.openSession();

        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        mapper.update(a);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public PageBean<AssetCategory> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //分页查询
        List< AssetCategory> assetCategories = mapper.selectByPage(begin,size);

        //查询总条数
        int totalCount = mapper.selectTotalCount();

        //封装
        PageBean<AssetCategory> pageBean = new PageBean<>();
        pageBean.setRows(assetCategories);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<AssetCategory> selectByPageAndCondition(int currentPage, int pageSize, AssetCategory a) {
        SqlSession sqlSession = factory.openSession();
        AssetCategoryMapper mapper = sqlSession.getMapper(AssetCategoryMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String ano = a.getAssetCategoryNo();
        if(ano != null && ano.length() > 0){
            ano = "%"+ ano +"%";
            a.setAssetCategoryNo(ano);
        }
        String dp = a.getAssetCategoryDescription();
        if(dp != null && dp.length() > 0){
            dp = "%"+ dp +"%";
            a.setAssetCategoryDescription(dp);
        }

        //当前页数据
        List<AssetCategory> assetCategories = mapper.selectByPageAndCondition(begin,size,a);

        int totalCount = mapper.selectTotalCountByCondition(a);

        //封装
        PageBean<AssetCategory> pageBean = new PageBean<>();
        pageBean.setRows(assetCategories);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
