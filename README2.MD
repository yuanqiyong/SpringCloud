# 服务降级限流：
### 1.APM技术选型
> APM，全称：Application Performance Management

-   **cat** 

    由大众点评开源，基于Java开发的实时应用监控平台，包括实时应用监控，业务监控 。 集成方案是通过
    代码埋点的方式来实现监控，比如： 拦截器，注解，过滤器等。   对代码的侵入性很大，集成成本较高。
    风险较大。 
    
     支持技术栈： 
    - dubbo
    - spring mvc ,spring aop ,springmvc-url
    - spring boot
    - mybatis
    - log4j , logback
    - playframework
    - http请求
    - zipkin

    由Twitter团队开源， Zipkin是一个分布式的跟踪系统。它有助于收集数据需要解决潜在的问题在市微服架构的时机。它管理数据的收集和查找 . 
    该产品结合spring-cloud-sleuth使用较为简单， 集成很方便。  但是功能较简单。 

     支持技术栈： 
    - spring cloud (是结合spring-cloud-sleuth支持的技术栈)
  

-   **pinpoint**

    由韩国团队naver团队开源，针对大规模分布式系统用链路监控，使用java写的工具。灵感来自短小精悍，帮助分析系统的总
    体结构和内部组件如何被调用在分布式应用提供了一个很好的解决方案。
    使用java探针字节码增加技术，实现对整个应用的监控 。 对应用零侵入

     支持技术栈： 
    - Tomcat 6+, Jetty 8/9, JBoss 6, Resin 4, Websphere 6+, Vertx 3.3+
    - Spring, Spring Boot (Embedded Tomcat, Jetty)
    - HTTP Client 3.x/4.x, HttpConnector, GoogleHttpClient, OkHttpClient, NingAsyncHttpClient
    - Thrift, Dubbo
    - mysql, oracle, mssql, cubrid,PostgreSQL, maria
    - arcus, memcached, redis, cassandra
    - MyBatis
    - DBCP, DBCP2, HIKARICP
    - gson, Jackson, Json Lib
    - log4j, Logback
-   **skywalking** 

    2015年由个人吴晟（华为开发者）开源 ， 2017年加入Apache孵化器。 
    针对分布式系统的应用性能监控系统，特别针对微服务、cloud native和容器化(Docker, Kubernetes, Mesos)架构， 其核心是个分布式追踪系统。
    使用java探针字节码增加技术，实现对整个应用的监控 。 对应用零侵入
    
     支持技术栈
    - Tomcat7+ , resin3+, jetty
    - spring boot ,spring mvc
    - strtuts2
    - spring RestTemplete  ,spring-cloud-feign
    - okhttp , httpClient
    - msyql ,oracle , H2 , sharding-jdbc,PostgreSQL
    - dubbo,dubbox ,motan, gRpc ,
    - rocketMq , kafla
    - redis, mongoDB,memcached ,
    - elastic-job , Netflix Eureka , Hystric

#### 对比：

  表头  | 表头
  ------------- | -------------
 单元格内容  | 单元格内容
 单元格内容l  | 单元格内容
