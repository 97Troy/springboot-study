package com.management.domain;

public class Code {
    //尾数1为成功，0为失败
    public static final Integer SAVE_OK=20011;//新增
    public static final Integer DELETE_OK=20021;//删除
    public static final Integer UPDATE_OK=20031;//修改
    public static final Integer GET_OK=20041;//查询

    public static final Integer SAVE_ERR=20010;
    public static final Integer DELETE_ERR=20020;
    public static final Integer UPDATE_ERR=20030;
    public static final Integer GET_ERR=20040;

    // 异常状态码
    public static final Integer SYSTEM_ERR=50001;
    public static final Integer SYSTEM_TIMEOUT_ERR=50002;
    public static final Integer BUSINESS_ERR=60002;
    public static final Integer SYSTEM_UNKNOWN_ERR=59999;

    //权限码
    public static final Integer USER_TEACHER=1;
    public static final Integer USER_STUDENT=2;
}
