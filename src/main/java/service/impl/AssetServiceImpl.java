package service.impl;

import Mapper.AssetMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Asset;
import pojo.PageBean;
import service.AssetService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class AssetServiceImpl implements AssetService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Asset> selectAll() {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        List<Asset> assets = mapper.selectAll();

        sqlSession.close();

        return assets;
    }

    @Override
    public void add(Asset a) {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        mapper.add(a);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByAssetNo(String ano) {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        mapper.deleteByAssetNo(ano);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByAssetNos(List<String> anos) {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        mapper.deleteByAssetNos(anos);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void update(Asset a) {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        mapper.update(a);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public PageBean<Asset> selectByPageAndCondition(int currentPage, int pageSize, Asset a) {
        SqlSession sqlSession = factory.openSession();

        AssetMapper mapper = sqlSession.getMapper(AssetMapper.class);

        //计算开始索引和条目
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        //模糊处理
        String ano = a.getAssetNo();
        if (ano != null && ano.length() > 0) {
            ano = "%" + ano + "%";
            a.setAssetNo(ano);
        }
        String dp = a.getAssetDescription();
        if (dp != null && dp.length() > 0) {
            dp = "%" + dp + "%";
            a.setAssetDescription(dp);
        }

        //当前页数据
        List<Asset> assets = mapper.selectByPageAndCondition(begin, size, a);

        int totalCount = mapper.selectTotalCountByCondition(a);

        //封装
        PageBean<Asset> pageBean = new PageBean<>();
        pageBean.setRows(assets);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
