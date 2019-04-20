package com.example.entity;

public class GoodsDetail {
    private Long id;

    private Long goodsid;

    private String specname;//规格名称

    private Integer stocknum;

    private Float unitprice;

    private String updatetime;

    private String createtime;

    public GoodsDetail(Long id, Long goodsid, String specname, Integer stocknum, Float unitprice, String updatetime, String createtime) {
        this.id = id;
        this.goodsid = goodsid;
        this.specname = specname;
        this.stocknum = stocknum;
        this.unitprice = unitprice;
        this.updatetime = updatetime;
        this.createtime = createtime;
    }

    public GoodsDetail() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public String getSpecname() {
        return specname;
    }

    public void setSpecname(String specname) {
        this.specname = specname == null ? null : specname.trim();
    }

    public Integer getStocknum() {
        return stocknum;
    }

    public void setStocknum(Integer stocknum) {
        this.stocknum = stocknum;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
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

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "id=" + id +
                ", goodsid=" + goodsid +
                ", specname='" + specname + '\'' +
                ", stocknum=" + stocknum +
                ", unitprice=" + unitprice +
                ", updatetime='" + updatetime + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}