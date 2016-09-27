# Spring Cloud Demo - 微服务框架示例

## 部分组件说明

- configserver

	配置服务组件。作为基础服务，为其他组件提供可实时生效的配置文件更新服务。
	配置文件基于Git，(Git地址)[http://git.qiyestore.com/qiyestore/cloud-config-repo]

- discovery

	服务注册组件。为各个微服务提供注册及生命周期管理

- apiproxy

	服务代理组件。为各个微服务提供统一访问的代理入口，结合Robbin可以实现客户端的负载均衡实现(demo中暂未使用robbin)

- hystrix

	服务监控组件。为各个微服务提供监控状态服务，同时为微服务方法提供fallbackMethod


## Demo编译及启动方法

### 依赖包

- Docker & Docker-Compose

	具体安装方法请参照 (此链接)[https://docs.docker.com/docker-for-windows/]

- Grails `3.1.10`

- Gradle `3.0`

### 服务组件编译

编译 configserver

> cd configserver
> gradle buildDocker

编译 discovery

> cd discovery
> gradle buildDocker

编译 apiproxy

> cd apiproxy
> gradle buildDocker

编译 hystrix

> cd hystrix
> gradle buildDocker

### 服务组件启动方法

> cd docker
> docker-compose up
>
> ( 如想暂停，同时按Ctrl+C )

第一次使用`up`参数启动成功以后，如果想后台运行服务组件，命令如下：

> 启动
> docker-compose start
>
> 停止
> docker-compose stop
>