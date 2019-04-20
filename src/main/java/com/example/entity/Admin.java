package com.example.entity;

public class Admin {
    private Long id;

    private String account;

    private String name;

    private String password;

    public Admin(Long id, String account, String name, String password) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
    }

    public Admin() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}