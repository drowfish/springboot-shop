package com.example.service;

import com.example.dao.CommentMapper;
import com.example.entity.Comment;
import com.example.entity.CommentExample;
import com.example.entity.CommentInfo;
import com.example.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserService userService;
    public List<CommentInfo> getCommentByGoodsId(Long goodsid){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);
        List<Comment> list = commentMapper.selectByExample(commentExample);
        List<CommentInfo> list1 = new ArrayList<>();

        if(list.isEmpty()){
            return list1;
        }

        for(Comment item : list){
            User user = userService.getUserById(item.getUserid());
            if(user == null){
                continue;
            }

            User user1 = new User();
            user1.setId(user.getId());
            user1.setNickname(user.getNickname());
            user1.setHeadimg(user.getHeadimg());

            CommentInfo commentInfo = new CommentInfo(item.getId(),user1,item.getContent(),item.getScore(),item.getCreatetime());

            list1.add(commentInfo);
        }
        return list1;
    }

    public List<Comment> hasComment(Long orderId){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        return commentMapper.selectByExample(commentExample);
    }

    public void sendComment(Comment comment){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        comment.setCreatetime(string);
        commentMapper.insert(comment);
    }
}
