package com.example.controller;

import com.example.entity.Type;
import com.example.service.TypeService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/type")
@ResponseBody
public class TypeController {

    @Resource
    private TypeService typeService;

    @RequestMapping("/getType")
    public Result getType(){
        List<Type> list = typeService.getType();
        if(list.isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETTYPEFAIL,list);
        }
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.GETTYPESUCCESS,list);
    }

    @RequestMapping("/addType")
    public Result addType(@RequestBody Type type){
        if(!typeService.getTypeByName(type.getName()).isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETTYPEBYNAME,null);
        }
        int flag = typeService.addType(type);
        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDSCUESS,null);
        }
        return new Result(StateAndMessage.FAIL,StateAndMessage.ADDFAIL,null);
    }
}
