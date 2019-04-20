package com.example.entity;

public class Order {
    private Long id;

    private Long userid;

    private Long goodsdetailid;

    private Integer goodsnum;

    private Float amount;

    private Integer state;

    private String updatetime;

    private String createtime;

    public Order(Long id, Long userid, Long goodsdetailid, Integer goodsnum, Float amount, Integer state, String updatetime, String createtime) {
        this.id = id;
        this.userid = userid;
        this.goodsdetailid = goodsdetailid;
        this.goodsnum = goodsnum;
        this.amount = amount;
        this.state = state;
        this.updatetime = updatetime;
        this.createtime = createtime;
    }

    public Order() {
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

    public Long getGoodsdetailid() {
        return goodsdetailid;
    }

    public void setGoodsdetailid(Long goodsdetailid) {
        this.goodsdetailid = goodsdetailid;
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
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}