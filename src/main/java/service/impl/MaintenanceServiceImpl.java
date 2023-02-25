package service.impl;

import Mapper.MaintenanceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Maintenance;
import pojo.PageBean;
import service.MaintenanceService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class MaintenanceServiceImpl implements MaintenanceService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Maintenance> selectAll() {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        List<Maintenance> maintenances = mapper.selectAll();
        sqlSession.close();
        return maintenances;
    }

    @Override
    public void add(Maintenance m) {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        mapper.add(m);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByMaintenanceNo(String mno) {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        mapper.deleteByMaintenanceNo(mno);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByMaintenanceNos(List<String> mnos) {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        mapper.deleteByMaintenanceNos(mnos);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void update(Maintenance m) {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        mapper.update(m);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public PageBean<Maintenance> selectByPageAndCondition(int currentPage, int pageSize, Maintenance m) {
        SqlSession sqlSession = factory.openSession();
        MaintenanceMapper mapper = sqlSession.getMapper(MaintenanceMapper.class);
        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String mno = m.getMaintenanceNo();
        if(mno != null && mno.length() > 0){
            mno = "%"+ mno +"%";
            m.setMaintenanceNo(mno);
        }
        String dp = m.getMaintenanceDescription();
        if(dp != null && dp.length() > 0){
            dp = "%"+ dp +"%";
            m.setMaintenanceDescription(dp);
        }

        //当前页数据
        List<Maintenance> maintenances = mapper.selectByPageAndCondition(begin,size,m);

        int totalCount = mapper.selectTotalCountByCondition(m);

        //封装
        PageBean<Maintenance> pageBean = new PageBean<>();
        pageBean.setRows(maintenances);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
