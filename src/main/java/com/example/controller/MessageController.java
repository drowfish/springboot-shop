package com.example.controller;

import com.example.entity.Message;
import com.example.entity.MessageInfo;
import com.example.service.MessageService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/message")
@ResponseBody
public class MessageController {

    @Resource
    private MessageService messageService;
    //通过商品id查询该商品的问答
    @RequestMapping("/getMessageByGoodsId")
    public Result getMessageByGoodsId(Long goodsid){
        List<MessageInfo> list = messageService.getMessageByGoodsId(goodsid);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }

    //提问信息
    @RequestMapping("/askMessage")
    public Result askMessage(@RequestBody Message message, HttpSession session){
        Long id = (Long) session.getAttribute("id");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = simpleDateFormat.format(date);

        message.setUserid(id);
        message.setCreatetime(string);

        messageService.askMessage(message);

        return new Result(StateAndMessage.SUCCESS,"",null);
    }

    @RequestMapping("/getNoReplyMsg")
    public Result getNoReplyMsg(){
        List<MessageInfo> list = messageService.getMsgByState(0);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }

    @RequestMapping("/getRepliedMsg")
    public Result getRepliedMsg(){
        List<MessageInfo> list = messageService.getMsgByState(1);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }

    @RequestMapping("/updateMessage")
    public Result updateMessage(@RequestBody Message message){
        messageService.updateMessage(message);
        return new Result(StateAndMessage.SUCCESS,"",null);
    }

}
