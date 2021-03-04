# HankoFramework

平台参考mall-swarm、pig开源项目

## 一、架构设计

![](D:\downloads\HanoFramework-SpringCloud微服务分布式架构.png)

## 二、技术选型

|                    |                                            |
| ------------------ | ------------------------------------------ |
| SpringCloud        | SpringCloud Hoxton.SR9                     |
|                    | Springboot 2.3.5.RELEASE                   |
| 数据库             | Mysql                                      |
|                    | Mysql-plus                                 |
|                    | pagehelper                                 |
|                    | mybatis-plus-generator(代码自动生成)       |
| 缓存               | Redis                                      |
|                    | Spring @Cacheable                          |
| 文件存储           | Minio                                      |
| 工具类             | hutool                                     |
| 注册中心、配置中心 | Nacos                                      |
| 网关               | gateway                                    |
| 安全               | springsecurity+oauth2+jwt+gateway(webflux) |
|                    |                                            |
|                    |                                            |
|                    |                                            |




## 三、表设计

![image-20210304193454987](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210304193454987.png)

​	

sys_permission 用户权限表(包含资源、操作)

sys_menu菜单表(特殊资源表)

## 四、编码

- 目录 

hankofw

hankofw-admin-web

hankofw-web



- 包目录

com.hankofw



