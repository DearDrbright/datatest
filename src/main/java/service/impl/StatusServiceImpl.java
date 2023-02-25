package service.impl;

import Mapper.StatusMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.PageBean;
import pojo.Status;
import service.StatusService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class StatusServiceImpl implements StatusService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Status> selectAll() {
        SqlSession sqlSession = factory.openSession();

        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        List<Status> statuses = mapper.selectAll();

        sqlSession.close();

        return statuses;
    }

    @Override
    public void add(Status s) {
        SqlSession sqlSession = factory.openSession();

        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        mapper.add(s);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByStatusNo(String sno) {
        SqlSession sqlSession = factory.openSession();

        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        mapper.deleteByStatusNo(sno);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByStatusNos(List<String> snos) {
        SqlSession sqlSession = factory.openSession();

        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        mapper.deleteByStatusNos(snos);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void update(Status s) {
        SqlSession sqlSession = factory.openSession();

        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        mapper.update(s);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public PageBean<Status> selectByPageAndCondition(int currentPage, int pageSize, Status s) {
        SqlSession sqlSession = factory.openSession();
        StatusMapper mapper = sqlSession.getMapper(StatusMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String sno = s.getStatusNo();
        if(sno != null && sno.length() > 0){
            sno = "%"+ sno +"%";
            s.setStatusNo(sno);
        }
        String dp = s.getStatusDescription();
        if(dp != null && dp.length() > 0){
            dp = "%"+ dp +"%";
            s.setStatusDescription(dp);
        }

        //当前页数据
        List<Status> statuses = mapper.selectByPageAndCondition(begin,size,s);

        int totalCount = mapper.selectTotalCountByCondition(s);

        //封装
        PageBean<Status> pageBean = new PageBean<>();
        pageBean.setRows(statuses);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
