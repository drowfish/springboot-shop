package com.example.entity;

public class OrderInfo {
    private Long id;

    private User user;

    private GoodsInfo goodsInfo;

    private GoodsDetail goodsDetail;

    private Integer goodsnum;

    private Float amount;

    private Integer state;//0：未付款 1：已付款未发货 2：待收货 3：已完成

    private boolean hasComment;

    private String updatetime;

    private String createtime;

    public OrderInfo(Long id, User user, GoodsInfo goodsInfo, GoodsDetail goodsDetail, Integer goodsnum, Float amount, Integer state, boolean hasComment, String updatetime, String createtime) {
        this.id = id;
        this.user = user;
        this.goodsInfo = goodsInfo;
        this.goodsDetail = goodsDetail;
        this.goodsnum = goodsnum;
        this.amount = amount;
        this.state = state;
        this.hasComment = hasComment;
        this.updatetime = updatetime;
        this.createtime = createtime;
    }

    public OrderInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }
}
