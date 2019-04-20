package com.example.entity;

public class Goods {
    private Long id;

    private String name;

    private Long typeid;

    private String img;

    private String updatetime;

    private String createtime;

    private String description;

    public Goods(Long id, String name, Long typeid, String img, String updatetime, String createtime, String description) {
        this.id = id;
        this.name = name;
        this.typeid = typeid;
        this.img = img;
        this.updatetime = updatetime;
        this.createtime = createtime;
        this.description = description;
    }

    public Goods() {
        super();
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
        this.name = name == null ? null : name.trim();
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
        this.img = img == null ? null : img.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}