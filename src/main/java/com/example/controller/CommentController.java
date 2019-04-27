package com.example.controller;

import com.example.entity.Comment;
import com.example.entity.CommentInfo;
import com.example.service.CommentService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/comment")
@ResponseBody
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/getCommentByGoodsId")
    public Result getCommentByGoodsId(Long goodsid){
        List<CommentInfo> list = commentService.getCommentByGoodsId(goodsid);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }

    @RequestMapping("/sendComment")
    public Result sendComment(@RequestBody Comment comment, HttpSession session){
        Long userid = (Long)session.getAttribute("id");
        comment.setUserid(userid);
        commentService.sendComment(comment);
        return new Result(StateAndMessage.SUCCESS,"",null);
    }
}
