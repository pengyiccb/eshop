开发手册-简明教程
==

# 0. 使用的技术和参考
- springBoot [Web框架](https://spring.io/guides/gs/spring-boot/)
- Spring Security [权限管理](https://spring.io/guides/gs/securing-web/)
- Mybatis [数据库框架](http://www.mybatis.org/mybatis-3/zh/index.html)
- MyBatis Generator [数据库自动生成器](https://blog.csdn.net/isea533/article/details/42102297)
- Mapper [自动配置的映射器](https://github.com/abel533/Mapper)
- pagehelper [分页器](https://github.com/pagehelper/Mybatis-PageHelper)
- mysql 数据库
- ehcache 缓存
- redis 缓存
- fastjson json解析器
- okhttp3 [http库](http://square.github.io/okhttp/)

参考资料:     
[Spring Boot基础教程-1](http://tengj.top/2017/04/24/springboot0/)

[Spring-Boot基础教程-2](http://blog.didispace.com/Spring-Boot%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)

 
# 1. 后端开发步骤总览
    
    理论上来, 后端开发提供的是数据

- 编写 HTML 网页，实现用户交互。 （视图层）
- 编写 Controller，配置url路由接口。（控制层）
- 编写 Service，实现业务逻辑。（业务层）
- 编写 Mybatis 的 Mapper 映射器。（DAO持久层）



## 1.1 Service 层编写规范。
    
    Service封装了业务，也是最方便入手的一层。
    我们先来完成一个Service
    
```
    
```
    
    
