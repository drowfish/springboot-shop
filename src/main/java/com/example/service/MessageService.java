package com.example.service;

import com.example.dao.MessageMapper;
import com.example.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private UserService userService;
    @Resource
    private ReplyService replyService;
    @Resource
    private GoodsService goodsService;

    public List<MessageInfo> getMessageByGoodsId(Long goodsid){
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);
        List<Message> list = messageMapper.selectByExample(messageExample);
        List<MessageInfo> list1 = new ArrayList<>();

        if(list.isEmpty()){
            return list1;
        }

        for (Message item : list){
            User user = userService.getUserById(item.getUserid());
            if(user == null){
                continue;
            }
            User user1 = new User();
            user1.setId(user.getId());
            user1.setNickname(user.getNickname());
            Reply reply = replyService.getReplyByMsgId(item.getId());
            GoodsInfo goodsInfo = goodsService.getGoodsInfo(item.getGoodsid());
            if(goodsInfo == null)
                continue;
            MessageInfo messageInfo = new MessageInfo(item.getId(),goodsInfo,item.getContent(),item.getState(),item.getCreatetime(),user1,reply);
            list1.add(messageInfo);
        }
        return list1;
    }

    public void askMessage(Message message){
        messageMapper.insert(message);
    }

    public List<MessageInfo> getMsgByState(Integer state){
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andStateEqualTo(state);
        List<Message> list = messageMapper.selectByExample(messageExample);
        List<MessageInfo> list1 = new ArrayList<>();

        if(list.isEmpty()){
            return list1;
        }

        for (Message item : list){
            User user = userService.getUserById(item.getUserid());
            if(user == null){
                continue;
            }
            User user1 = new User();
            user1.setId(user.getId());
            user1.setNickname(user.getNickname());
            user1.setHeadimg(user.getHeadimg());
            GoodsInfo goodsInfo = goodsService.getGoodsInfo(item.getGoodsid());
            if(goodsInfo == null)
                continue;
            Reply reply = replyService.getReplyByMsgId(item.getId());
            MessageInfo messageInfo = new MessageInfo(item.getId(),goodsInfo,item.getContent(),item.getState(),item.getCreatetime(),user1,reply);
            list1.add(messageInfo);
        }
        return list1;
    }

    public void updateMessage(Message message){
        messageMapper.updateByPrimaryKeySelective(message);
    }
}
