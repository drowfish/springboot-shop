package com.example.controller;

import com.example.entity.Reply;
import com.example.service.ReplyService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/reply")
@ResponseBody
public class ReplyController {

    @Resource
    private ReplyService replyService;
    @RequestMapping("/replyMsg")
    public Result replyMsg(@RequestBody Reply reply){
        replyService.replyMsg(reply);
        return new Result(StateAndMessage.SUCCESS,"",null);
    }
}
