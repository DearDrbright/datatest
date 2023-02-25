package service.impl;

import Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import service.UserService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class UserServiceImpl implements UserService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public boolean register(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null){
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        //5、释放资源
        sqlSession.close();

        return u == null;

    }

    @Override
    public User selectByUser(User user) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        User u = mapper.selectByUser(user);

        //5. 释放资源
        sqlSession.close();

        return u;
    }

    @Override
    public List<User> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        List<User> users = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return users;
    }

    @Override
    public User selectByUsername(String username) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.selectByUsername(username);

        return user;
    }
}
