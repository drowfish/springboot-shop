package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.entity.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int regist(User user){
        return userMapper.insert(user);
    }

    public List<User> getUserByEmail(String email){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(userExample);
    }

    public List<User> allUser(){
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id ASC");
        return userMapper.selectByExample(userExample);
    }

    public int deleteUser(Long id){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        return userMapper.deleteByExample(userExample);
    }

    public List<User> searchUser(String word){
        UserExample userExample = new UserExample();
        userExample.or().andEmailEqualTo(word);
        userExample.or().andPhoneEqualTo(word);
        userExample.or().andNicknameLike("%"+word+"%");
        userExample.or().andRecipientLike("%"+word+"%");
        userExample.or().andAddressLike("%"+word+"%");
        return userMapper.selectByExample(userExample);
    }


    public User getUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void updateUserData(User user){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        user.setUpdatetime(string);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
