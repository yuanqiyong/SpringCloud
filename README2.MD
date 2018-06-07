# 服务降级限流：
### 1.APM技术选型
> APM，全称：Application Performance Management

-   **cat** 

    由大众点评开源，基于Java开发的实时应用监控平台，包括实时应用监控，业务监控 。 集成方案是通过
    代码埋点的方式来实现监控，比如： 拦截器，注解，过滤器等。   对代码的侵入性很大，集成成本较高。
    风险较大。 
    
    > 支持技术栈： 
    >- dubbo
    >- spring mvc ,spring aop ,springmvc-url
    >- spring boot
    >- mybatis
    >- log4j , logback
    >- playframework
    >- http请求
-   zipkin

    由Twitter团队开源， Zipkin是一个分布式的跟踪系统。它有助于收集数据需要解决潜在的问题在市微服架构的时机。它管理数据的收集和查找 . 
    该产品结合spring-cloud-sleuth使用较为简单， 集成很方便。  但是功能较简单。 
    > 支持技术栈： 
    >- spring cloud (是结合spring-cloud-sleuth支持的技术栈)
  

-   **pinpoint**

    由韩国团队naver团队开源，针对大规模分布式系统用链路监控，使用java写的工具。灵感来自短小精悍，帮助分析系统的总
    体结构和内部组件如何被调用在分布式应用提供了一个很好的解决方案。
    使用java探针字节码增加技术，实现对整个应用的监控 。 对应用零侵入
    > 支持技术栈： 
    >- Tomcat 6+, Jetty 8/9, JBoss 6, Resin 4, Websphere 6+, Vertx 3.3+
    >- Spring, Spring Boot (Embedded Tomcat, Jetty)
    >- HTTP Client 3.x/4.x, HttpConnector, GoogleHttpClient, OkHttpClient, NingAsyncHttpClient
    >- Thrift, Dubbo
    >- mysql, oracle, mssql, cubrid,PostgreSQL, maria
    >- arcus, memcached, redis, cassandra
    >- MyBatis
    >- DBCP, DBCP2, HIKARICP
    >- gson, Jackson, Json Lib
    >- log4j, Logback
-   **skywalking** 

    2015年由个人吴晟（华为开发者）开源 ， 2017年加入Apache孵化器。 
    针对分布式系统的应用性能监控系统，特别针对微服务、cloud native和容器化(Docker, Kubernetes, Mesos)架构， 其核心是个分布式追踪系统。
    使用java探针字节码增加技术，实现对整个应用的监控 。 对应用零侵入
    > 支持技术栈
    >- Tomcat7+ , resin3+, jetty
    >- spring boot ,spring mvc
    >- strtuts2
    >- spring RestTemplete  ,spring-cloud-feign
    >- okhttp , httpClient
    >- msyql ,oracle , H2 , sharding-jdbc,PostgreSQL
    >- dubbo,dubbox ,motan, gRpc ,
    >- rocketMq , kafla
    >- redis, mongoDB,memcached ,
    >- elastic-job , Netflix Eureka , Hystric

#### 对比：
  | cat | zipkin | pinpoint | skywalking  
 ---  | ---  | --- | ---  | ---  | --- 
依赖|Java 6，7，8<br>Maven 3.2.3+<br>mysql5.6<br>Linux 2.6以及之上（2.6内核才可以支持epoll）|Java 6，7，8<br>Maven3.2+<br>rabbitMQ|Java 6，7，8<br>maven3+<br>Hbase0.94+|Java 6，7，8<br>maven3.0+<br>elasticsearch
实现方式|代码埋点（拦截器，注解，过滤器等）|拦截请求，发送（HTTP，mq）数据至zipkin服务|java探针，字节码增强|java探针，字节码增强
存储选择|mysql，hdfs|in-memory ， mysql ， Cassandra ， Elasticsearch|HBase|elasticsearch，H2
通信方式| - |http ， MQ|thrift|GRPC
MQ监控|不支持|不支持|不支持|支持（RocketMQ，kafka）
全局调用统计|支持|不支持|支持|支持
trace查询|不支持|支持|不支持|支持
报警|支持|不支持|支持|支持
JVM监控|不支持|不支持|支持|支持
优点|功能完善。|spring-cloud-sleuth可以很好的集成zipkin ， 代码无侵入，集成非常简单 ， 社区更加活跃。|完全无侵入， 仅需修改启动方式，界面完善，功能细致。|完全无侵入，界面完善，支持应用拓扑图及单个调用链查询。
缺点|代码侵入性较强，需要埋点<br>文档比较混乱，文档与发布版本的符合性较低，需要依赖点评私服 （或者需要把他私服上的jar手动下载下来，然后上传到我们的私服上去）。|默认使用的是http请求向zipkin上报信息，耗性能。<br>跟sleuth结合可以使用rabbitMQ的方式异步来做，增加了复杂度，需要引入rabbitMQ 。 |不支持查询单个调用链， 对外表现的是整个应用的调用生态。|3.2版本之前BUG较多 ，网上反映兼容性较差 . 3.2新版本的反映情况较少<br>依赖较多。
官网|[https://github.com/dianping/cat](https://github.com/dianping/cat)|[http://zipkin.io/](http://zipkin.io/)|[https://github.com/naver/pinpoint](https://github.com/naver/pinpoint)|[http://skywalking.apache.org/](http://skywalking.apache.org/)
开发者|大众点评|twitter|naver|吴晟（华为开发者）<br>目前已经加入Apache孵化器
使用公司|大众点评， 携程， 陆金所，同程旅游，猎聘网|twitter|naver|华为软件开发云、天源迪科、当当网、京东金融
