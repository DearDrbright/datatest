package service.impl;

import Mapper.ValuationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.PageBean;
import pojo.Valuation;
import service.ValuationService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ValuationServiceImpl implements ValuationService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Valuation> selectAll() {
        SqlSession sqlSession = factory.openSession();

        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        List<Valuation> valuations = mapper.selectAll();

        sqlSession.close();

        return valuations;
    }

    @Override
    public void add(Valuation v) {
        SqlSession sqlSession = factory.openSession();

        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        mapper.add(v);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByValuationNo(String vno) {
        SqlSession sqlSession = factory.openSession();

        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        mapper.deleteByValuationNo(vno);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByValuationNos(List<String> vnos) {
        SqlSession sqlSession = factory.openSession();

        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        mapper.deleteByValuationNos(vnos);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void update(Valuation v) {
        SqlSession sqlSession = factory.openSession();

        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        mapper.update(v);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public PageBean<Valuation> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //分页查询
        List<Valuation> valuations = mapper.selectByPage(begin,size);

        //查询总条数
        int totalCount = mapper.selectTotalCount();

        //封装
        PageBean<Valuation> pageBean = new PageBean<>();
        pageBean.setRows(valuations);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Valuation> selectByPageAndCondition(int currentPage, int pageSize, Valuation v) {
        SqlSession sqlSession = factory.openSession();
        ValuationMapper mapper = sqlSession.getMapper(ValuationMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String vno = v.getValuationNo();
        if(vno != null && vno.length() > 0){
            vno = "%"+ vno +"%";
            v.setValuationNo(vno);
        }
        String ano = v.getAssetNo();
        if(ano != null && ano.length() > 0){
            ano = "%"+ ano +"%";
            v.setAssetNo(ano);
        }
        String eno = v.getEmployeeNo();
        if(eno != null && eno.length() > 0){
            eno = "%"+ eno +"%";
            v.setEmployeeNo(eno);
        }

        //当前页数据
        List<Valuation> valuations = mapper.selectByPageAndCondition(begin,size,v);

        int totalCount = mapper.selectTotalCountByCondition(v);

        //封装
        PageBean<Valuation> pageBean = new PageBean<>();
        pageBean.setRows(valuations);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
