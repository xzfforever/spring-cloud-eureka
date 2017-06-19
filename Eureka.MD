##Spring Cloud Eureka
<li>Eureka 知识点
>1、Eureka Server可以配置为HA（高可用），每个服务器间都会复制所注册服务的信息<br/>
>2、Eureka 配置信息（EurekaInstanceConfigBean、EurekaClientConfigBean）<br/>
>3、eureka.client.healthcheck.enabled=true只能在application.properties/.yml中配置，在bootstrap.yml配置可能会引起未知的错误<br/>
>4、如果想对心跳机制有更多的控制，可以自己实现接口：com.netflix.appinfo.HealthCheckHandler<br/>
>5、Eureka Region && Zone 概念
<pre>![](https://raw.githubusercontent.com/xzfforever/images/master/eureka/eureka_zone.jpg)
<pre>Eureka支持Region和Zone的概念。其中一个Region可以包含多个Zone。Eureka在启动时需要指定一个Zone名，即当前Eureka属于哪个zone, 如果不指定则属于defaultZone。<br/>Eureka Client也需要指定Zone, Client(当与Ribbon配置使用时)在向Server获取注册列表时会优先向自己Zone的Eureka发请求，如果自己Zone中的Eureka全挂了才会尝试向其它Zone。<br/>当获取到远程服务列表后，Client也会优先向同一个Zone的服务发起远程调用。Region和Zone可以对应于现实中的大区和机房，如在华北地区有10个机房，在华南地区有20个机房，<br/>那么分别为Eureka指定合理的Region和Zone能有效避免跨机房调用，同时一个地区的Eureka坏掉不会导致整个该地区的服务都不可用。</pre>




<li>参考资料
>http://www.jianshu.com/p/ef2591899597 (Eureka源码分析)
>http://www.360java.com/architecture/7247.html（Eureka常见问题汇总）




<li>相关问题<br>
>1、更新了instanceId，重新，旧instanceId,依然会存在，但过段时间会被清除，以下是日志记录：
<pre>
2017-06-19 10:39:43.561  WARN 7816 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : DS: Registry: expired lease for USER-CENTER/UEX4UMCBLACFA8X:user-center:8888
2017-06-19 10:39:43.569  INFO 7816 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Cancelled instance USER-CENTER/UEX4UMCBLACFA8X:user-center:8888 (replication=false)
</pre>