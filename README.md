# Spring Cloud Demo - 微服务框架示例

* [SpringCloud介绍](#springcloud介绍)
* [部分组件说明](#部分组件说明)
* [组件编译及启动方法](#组件编译及启动方法)
	* [依赖包](#依赖包)
	* [服务组件编译](#服务组件编译)
	* [服务组件启动方法](#服务组件启动方法)
* [DEMO测试](#demo测试)
	* [服务组件启动方法](#服务组件启动方法)
	* [运行业务DEMO](#运行业务demo)
* [参考资料](#参考资料)
* [待开发功能](#待开发功能)

## SpringCloud介绍

![SpringCloudConfig图示](https://programmaticponderings.files.wordpress.com/2016/01/spring_cloud_config_2.png?w=1252)

## 部分组件说明

- configserver

	配置服务组件。作为基础服务，为其他组件提供可实时生效的配置文件更新服务。
	配置文件基于Git, `注：需修改对应Git服务配置`

- discovery

	服务注册组件。为各个微服务提供注册及生命周期管理

- apiproxy

	服务代理组件。为各个微服务提供统一访问的代理入口，结合Robbin可以实现客户端的负载均衡实现

- hystrix

	服务监控组件。为各个微服务提供监控状态服务，同时为微服务方法提供fallbackMethod


## 组件编译及启动方法

### 依赖包

- Docker & Docker-Compose

	具体安装方法请参照 [此链接](https://docs.docker.com/)

- Grails `3.1.10`

- Gradle `3.0`

### 服务组件编译

| 注：编译最后可能`会报错`，`不用管它`

编译 configserver

修改配置 `configserver/src/main/resources/application.yml`
```
spring:
  cloud:
    config:
      server:
        git:
          # 这里修改为你的git服务地址，用户名及密码
          uri: http://xxxxx/demo/cloud-config-repo.git
          username: xxxx #你的用户名
          password: xxxx #你的密码
```

```bash
cd configserver
gradle buildDocker
```

编译 discovery

```bash
cd discovery
gradle buildDocker
```

编译 apiproxy

```bash
cd apiproxy
gradle buildDocker
```

编译 hystrix

```bash
cd hystrix
gradle buildDocker
```

### 服务组件启动方法

```bash
cd docker
docker-compose up

( 如想暂停，同时按Ctrl+C )
```

第一次使用`up`参数启动成功以后，如果想后台运行服务组件，命令如下：

启动:

```bash
cd docker
docker-compose start
```

停止:

```bash
cd docker
docker-compose stop
```

## DEMO测试

### 运行用户微服务 

项目目录 `user-ms`。需要 Grails `3.1.10`

运行命令：
```bash
grails run-app
```

成功运行以后，测试REST服务

- 本地服务测试

	- 正常测试 [http://localhost:8080/user/findUsers](http://localhost:8080/user/findUsers)

	- failback测试 [http://localhost:8080/user/findUsersError](http://localhost:8080/user/findUsersError)

- 测试apiproxy

	- 正常测试 [http://localhost:8765/user/findUsers](http://localhost:8080/user/findUsers)

	- failback测试 [http://localhost:8765/user/findUsersError](http://localhost:8080/user/findUsersError)


### 运行业务DEMO

项目目录 `business-demo`。需要 Grails `3.1.10`

运行命令：
```bash
grails run-app --port=8090
```

成功运行以后，使用RestBuilder远程访问服务测试

[http://localhost:8090/demo](http://localhost:8090/demo)

## 参考资料

- SpringCloud官网 [http://projects.spring.io/spring-cloud/](http://projects.spring.io/spring-cloud/)
- SpringCloud官方部分入门Demo
	- [Building Java Projects with Gradle](https://spring.io/guides/gs/gradle/)
	- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
	- [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
	- [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)
	- [Routing and Filtering](https://spring.io/guides/gs/routing-and-filtering/)
	- [Client Side Load Balancing with Ribbon and Spring Cloud](https://spring.io/guides/gs/client-side-load-balancing/)
- 部分英文介绍&讲义
	- [Building a Microservice Federation with Grails](http://www.slideshare.net/SpringCentral/building-a-microservice-federation-with-grails)
	- [Microservice With Spring Boot and Spring Cloud](http://www.slideshare.net/ewolff/microservice-with-spring-boot-and-spring-cloud?qid=e812e95d-bd91-48b6-9648-0997feef2e53)


## 待开发功能

- 事件驱动型事务DEMO 

	基于消息中间件(如RabbitMQ,Kafka等)，实现分布式的消息驱动事务处理，例如：用户注册自动发优惠券，用户下单消费



