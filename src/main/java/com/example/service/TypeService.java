package com.example.service;

import com.example.dao.TypeMapper;
import com.example.entity.Type;
import com.example.entity.TypeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeMapper typeMapper;

    public List<Type> getType(){
        TypeExample typeExample = new TypeExample();
        typeExample.setOrderByClause("id ASC");
        return typeMapper.selectByExample(typeExample);
    }

    public int addType(Type type){
        return typeMapper.insert(type);
    }

    public List<Type> getTypeByName(String name){
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        criteria.andNameEqualTo(name);
        return typeMapper.selectByExample(typeExample);
    }
}
