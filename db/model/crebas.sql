/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/18 14:25:56                           */
/*==============================================================*/


drop table if exists XYZ_AREA;

drop table if exists XYZ_AREA_MNG_ORG;

drop table if exists XYZ_AREA_SEND_ORG;

/*==============================================================*/
/* Table: XYZ_AREA                                              */
/*==============================================================*/
create table XYZ_AREA
(
   ID                   bigint not null comment '区域ID',
   AREA_NAME            varchar(20) not null comment '区域名称',
   REMARK               varchar(50) comment '备注',
   ENTRY_TIME           datetime not null comment '录入时间',
   primary key (ID)
);

alter table XYZ_AREA comment '区域';

/*==============================================================*/
/* Table: XYZ_AREA_MNG_ORG                                      */
/*==============================================================*/
create table XYZ_AREA_MNG_ORG
(
   ID                   bigint not null comment '区域组织关系ID',
   AREA_ID              bigint not null comment '区域ID',
   MNG_ORG_ID           bigint not null comment '管理组织ID',
   ENTRY_TIME           datetime not null comment '录入时间',
   primary key (ID)
);

alter table XYZ_AREA_MNG_ORG comment '区域管理组织关系';

/*==============================================================*/
/* Table: XYZ_AREA_SEND_ORG                                     */
/*==============================================================*/
create table XYZ_AREA_SEND_ORG
(
   ID                   bigint not null comment '区域组织关系ID',
   AREA_ID              bigint not null comment '区域ID',
   SEND_ORG_ID          bigint not null comment '发货组织ID',
   ENTRY_TIME           datetime not null comment '录入时间',
   primary key (ID)
);

alter table XYZ_AREA_SEND_ORG comment '区域发货组织关系';

alter table XYZ_AREA_MNG_ORG add constraint FK_Relationship_2 foreign key (AREA_ID)
      references XYZ_AREA (ID) on delete restrict on update restrict;

alter table XYZ_AREA_SEND_ORG add constraint FK_Relationship_1 foreign key (AREA_ID)
      references XYZ_AREA (ID) on delete restrict on update restrict;

