package com.example.util.stateAndMessage;

public class StateAndMessage {

    public static final Integer FAIL = 0;
    public static final Integer SUCCESS = 1;

    //登录
    public static final String LOGINFSUCCESS = "登录成功";
    public static final String LOGINFAILBYEMAIL = "用户名错误";
    public static final String LOGINFAILBYPWD = "密码错误";

    //注册
    public static final String REGISTSUCCESS = "注册成功";
    public static final String REGISTFAIL = "该邮箱已被注册";

    public static final String DELETEUSERSUCCESS = "删除成功";
    public static final String DELETEUSERFAIL = "删除失败";

    public static final String GETALLUSERSUCCESS = "获取所有用户信息成功";
    public static final String GETALLUSERFAIL = "获取用户信息失败或无用户";

    public static final String SEARCHUSERFALI = "未查询到您所需要的内容";
    public static final String SEARCHUSERSUCCESS = "查询用户成功";

    public static final String GETTYPEFAIL = "未查询到商品类目";
    public static final String GETTYPESUCCESS = "查询类目成功";

    public static final String ADDFAIL = "添加失败";
    public static final String ADDSCUESS = "添加成功";

    public static final String GETTYPEBYNAME = "该类目已存在";

    public static final String GETGOODSBYTYPEFAIL = "未获取到相关商品或无该类型商品";
    public static final String GETGOODSBYTYPESUCCESS = "获取商品信息成功";

}
