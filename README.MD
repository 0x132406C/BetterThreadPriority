# 更好的线程优先级

**MC版本：** Minecraft 1.20.1

**Fabric版本：** Fabric 0.14.23

**Fabric API版本：** 0.90.0

**IDEA版本：** IDEA 2023.2.3

**作者：** 0x132406C

## 项目简介

提高渲染线程的系统优先级,解决服务器线程抢占渲染线程的CPU资源导致的剧烈卡顿

## 打开

通常直接点击build.gradle IDEA就会自动为你安排好,但是这是在没有网络限制的环境下


### 使用

使用fabric的remapJar编译为.jar文件,找到编译后的文件当做mod使用即可
