package service.impl;

import Mapper.ServiceAgentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.PageBean;
import pojo.ServiceAgent;
import service.ServiceAgentService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ServiceAgentServiceImpl implements ServiceAgentService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<ServiceAgent> selectAll() {
        SqlSession sqlSession = factory.openSession();

        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        List<ServiceAgent> serviceAgents = mapper.selectAll();

        sqlSession.close();

        return serviceAgents;
    }

    @Override
    public void add(ServiceAgent sa) {
        SqlSession sqlSession = factory.openSession();

        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        mapper.add(sa);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByServiceAgentNo(String sano) {
        SqlSession sqlSession = factory.openSession();

        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        mapper.deleteByServiceAgentNo(sano);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByServiceAgentNos(List<String> sanos) {
        SqlSession sqlSession = factory.openSession();

        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        mapper.deleteByServiceAgentNos(sanos);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void update(ServiceAgent sa) {
        SqlSession sqlSession = factory.openSession();

        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        mapper.update(sa);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public PageBean<ServiceAgent> selectByPageAndCondition(int currentPage, int pageSize, ServiceAgent sa) {
        SqlSession sqlSession = factory.openSession();
        ServiceAgentMapper mapper = sqlSession.getMapper(ServiceAgentMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String sano = sa.getAgentNo();
        if(sano != null && sano.length() > 0){
            sano = "%"+ sano +"%";
            sa.setAgentNo(sano);
        }
        String sn = sa.getAgentName();
        if(sn != null && sn.length() > 0){
            sn = "%"+ sn +"%";
            sa.setAgentName(sn);
        }

        //当前页数据
        List<ServiceAgent> serviceAgents = mapper.selectByPageAndCondition(begin,size,sa);

        int totalCount = mapper.selectTotalCountByCondition(sa);

        //封装
        PageBean<ServiceAgent> pageBean = new PageBean<>();
        pageBean.setRows(serviceAgents);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
