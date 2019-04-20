package com.example.service;

import com.example.dao.AdminMapper;
import com.example.entity.Admin;
import com.example.entity.AdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public List<Admin> getAdminByAccount(String account){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAccountEqualTo(account);
        return adminMapper.selectByExample(adminExample);
    }
}
