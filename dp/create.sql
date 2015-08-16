



create database dp_db character set utf8 default character set utf8 collate utf8_general_ci default collate utf8_general_ci;



create table t_user
(
    userId   bigint   comment "用户ID" auto_increment,
    username   varchar(64)   comment "帐号",
    password   varchar(32)   comment "密码",
    encryptKey   varchar(128)   comment "用户加密key",
    createTime   bigint   comment "注册时间",
    nickname   varchar(32)   comment "昵称",
    headImgUrl   varchar(255)   comment "头像图片地址",
    gender     tinyint		    comment "性别",
    constraint t_user_pk primary key (userId)
)  comment "用户实体";

