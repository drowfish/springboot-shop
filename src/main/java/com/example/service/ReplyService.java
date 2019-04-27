package com.example.service;

import com.example.dao.ReplyMapper;
import com.example.entity.Reply;
import com.example.entity.ReplyExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReplyService {

    @Resource
    private ReplyMapper replyMapper;

    public Reply getReplyByMsgId(Long messageId){

        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andMessageidEqualTo(messageId);
        List<Reply> list = replyMapper.selectByExample(replyExample);
        if(list.isEmpty())
            return null;
        return list.get(0);
    }

    public void replyMsg(Reply reply){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        reply.setCreatetime(string);
        replyMapper.insert(reply);
    }


}
