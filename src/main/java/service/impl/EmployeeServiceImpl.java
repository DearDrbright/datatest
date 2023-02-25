package service.impl;

import Mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Employee;
import pojo.PageBean;
import service.EmployeeService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Employee> selectAll() {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.selectAll();

        sqlSession.close();

        return employees;
    }

    @Override
    public void add(Employee e) {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.add(e);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public void deleteByEmployeeNo(String eno) {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.deleteByEmployeeNo(eno);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByEmployeeNos(List<String> enos) {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.deleteByEmployeeNos(enos);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void update(Employee e) {
        SqlSession sqlSession = factory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.update(e);
        sqlSession.commit();//提交事务

        sqlSession.close();
    }

    @Override
    public PageBean<Employee> selectByPageAndCondition(int currentPage, int pageSize, Employee e) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        //计算开始索引和条目
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //模糊处理
        String eno = e.getEmployeeNo();
        if(eno != null && eno.length() > 0){
            eno = "%"+ eno +"%";
            e.setEmployeeNo(eno);
        }
        String dp = e.getPosition();
        if(dp != null && dp.length() > 0){
            dp = "%"+ dp +"%";
            e.setPosition(dp);
        }

        //当前页数据
        List<Employee> Employees = mapper.selectByPageAndCondition(begin,size,e);

        int totalCount = mapper.selectTotalCountByCondition(e);

        //封装
        PageBean<Employee> pageBean = new PageBean<>();
        pageBean.setRows(Employees);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}
