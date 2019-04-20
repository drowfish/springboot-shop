package com.example.controller;

import com.example.entity.Admin;
import com.example.entity.Type;
import com.example.service.AdminService;
import com.example.util.JwtUtil;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/admin")
@ResponseBody
public class AdminController {

    @Resource
    AdminService adminService;

    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin){
        List<Admin> list = adminService.getAdminByAccount(admin.getAccount());
        Map<String,String> map = new HashMap<>();
        if(list.isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.LOGINFAILBYEMAIL,null);
        }else{
            if(!list.get(0).getPassword().equals(admin.getPassword())){
                return new Result(StateAndMessage.FAIL,StateAndMessage.LOGINFAILBYPWD,null);
            }
        }
        map.put("name",list.get(0).getAccount());
        String token = JwtUtil.getToken(list.get(0).getAccount());
        map.put("token","Bearer:"+token);
        System.out.println("token:"+token);
        return  new Result(StateAndMessage.SUCCESS,StateAndMessage.LOGINFSUCCESS, map);
    }
}
