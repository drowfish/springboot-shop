package com.example.entity;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GoodsInfo{
    private Long id;

    private String name;

    private Long typeid;

    private String img;

    private String updatetime;

    private String createtime;

    private String description;

    private List<GoodsDetail> list;

    public GoodsInfo(Long id, String name, Long typeid, String img, String updatetime, String createtime, String description, List<GoodsDetail> list) {
        this.id = id;
        this.name = name;
        this.typeid = typeid;
        this.img = img;
        this.updatetime = updatetime;
        this.createtime = createtime;
        this.description = description;
        this.list = list;
    }

    public GoodsInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GoodsDetail> getList() {
        return list;
    }

    public void setList(List<GoodsDetail> list) {
        this.list = list;
    }
}
