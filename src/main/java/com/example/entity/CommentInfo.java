package com.example.entity;

public class CommentInfo {
    private Long id;

    private User user;

    private String content;

    private Integer score;

    private String createtime;

    public CommentInfo(Long id, User user, String content, Integer score, String createtime) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.score = score;
        this.createtime = createtime;
    }

    public CommentInfo() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        this.createtime = createtime;
    }

}
