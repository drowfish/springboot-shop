package com.example.entity;

public class Comment {
    private Long id;

    private Long userid;

    private Long goodsid;

    private Long goodsdetailid;

    private Long orderid;

    private String content;

    private Integer score;

    private String createtime;

    public Comment(Long id, Long userid, Long goodsid, Long goodsdetailid, Long orderid, String content, Integer score, String createtime) {
        this.id = id;
        this.userid = userid;
        this.goodsid = goodsid;
        this.goodsdetailid = goodsdetailid;
        this.orderid = orderid;
        this.content = content;
        this.score = score;
        this.createtime = createtime;
    }

    public Comment() {
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

    public Long getGoodsdetailid() {
        return goodsdetailid;
    }

    public void setGoodsdetailid(Long goodsdetailid) {
        this.goodsdetailid = goodsdetailid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}