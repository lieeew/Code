-- auto-generated definition
create table user
(
    id           bigint auto_increment
        primary key,
    username     varchar(255)                       null comment '用户昵称',
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(256)                       not null comment '密码',
    phone        varchar(512)                       null comment '手机号',
    email        varchar(512)                       null comment '邮箱',
    userStatus   tinyint  default 0                 null comment '是否有效',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '替换时间',
    isDelete     tinyint  default 0                 null comment '是否删除',
    userRole     int      default 0                 not null comment '用户角色 0-普通会员  1-管理员',
    planetCode   varchar(512)                       null comment '星球编号'
);

