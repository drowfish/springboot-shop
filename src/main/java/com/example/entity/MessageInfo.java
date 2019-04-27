package com.example.entity;

public class MessageInfo {

    private Long id;

    private GoodsInfo goodsInfo;

    private String content;

    private Integer state;

    private String createtime;

    private User user;

    private Reply reply;

    public MessageInfo(Long id, GoodsInfo goodsInfo, String content, Integer state, String createtime, User user, Reply reply) {
        this.id = id;
        this.goodsInfo = goodsInfo;
        this.content = content;
        this.state = state;
        this.createtime = createtime;
        this.user = user;
        this.reply = reply;
    }

    public MessageInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
