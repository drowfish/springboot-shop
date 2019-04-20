package com.example.entity;

public class Message {
    private Long id;

    private Long userid;

    private Long goodsid;

    private String content;

    private Integer state;

    private String createtime;

    public Message(Long id, Long userid, Long goodsid, String content, Integer state, String createtime) {
        this.id = id;
        this.userid = userid;
        this.goodsid = goodsid;
        this.content = content;
        this.state = state;
        this.createtime = createtime;
    }

    public Message() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        this.createtime = createtime == null ? null : createtime.trim();
    }
}