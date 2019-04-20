package com.example.entity;

public class Reply {
    private Long id;

    private Long messageid;

    private String content;

    private String createtime;

    public Reply(Long id, Long messageid, String content, String createtime) {
        this.id = id;
        this.messageid = messageid;
        this.content = content;
        this.createtime = createtime;
    }

    public Reply() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}