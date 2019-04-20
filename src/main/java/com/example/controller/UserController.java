package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.JwtUtil;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Resource
    private UserService userService;

    //用户登录
    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        List<User> list = userService.getUserByEmail(user.getEmail());
        Map<String,String> map = new HashMap<>();
        if(list.isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.LOGINFAILBYEMAIL,null);
        }else{
            if(!list.get(0).getPassword().equals(user.getPassword())){
                return new Result(StateAndMessage.FAIL,StateAndMessage.LOGINFAILBYPWD,null);
            }
        }
        map.put("name",list.get(0).getNickname());
        String token = JwtUtil.getToken(list.get(0).getEmail());
        map.put("token","Bearer:"+token);
        System.out.println("token:"+token);
        return  new Result(StateAndMessage.SUCCESS,StateAndMessage.LOGINFSUCCESS, map);
    }

    //用户注册
    @RequestMapping("/regist")
    public Result regist(@RequestBody User user){
        Map<String,String> map = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        user.setUpdatetime(string);
        user.setCreatetime(string);
        if(!userService.getUserByEmail(user.getEmail()).isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.REGISTFAIL,null);
        }
        int flag = userService.regist(user);
        if(flag <= 0){
            return new Result(StateAndMessage.FAIL,StateAndMessage.REGISTFAIL,null);
        }
        map.put("name",user.getNickname());
        String token = JwtUtil.getToken(user.getEmail());
        map.put("token","Bearer:"+token);
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.REGISTSUCCESS,map);
    }

    //查询所有用户
    @RequestMapping("/allUser")
    public Result allUser(){
        List<User> list = userService.allUser();
        if(list.isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETALLUSERFAIL,list);
        }
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.GETALLUSERSUCCESS,list);
    }

    //根据id删除指定用户
    @RequestMapping("/deleteUser")
    public Result deleteUser(Long id){
        System.out.println("id"+id);
        if(userService.deleteUser(id)>0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.DELETEUSERSUCCESS,null);
        }else{
            return new Result(StateAndMessage.FAIL,StateAndMessage.DELETEUSERFAIL,null);
        }
    }

    //根据关键字查询用户
    @RequestMapping("/searchUser")
    public Result searchUser(String word){
        List<User> list = userService.searchUser(word);
        if(list.isEmpty()){
            return new Result(StateAndMessage.FAIL,StateAndMessage.SEARCHUSERFALI,list);
        }
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.SEARCHUSERSUCCESS,list);
    }
}
