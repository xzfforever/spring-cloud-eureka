##Spring Cloud Eureka


<li>参考资料
>http://www.jianshu.com/p/ef2591899597 (Eureka源码分析)
>http://www.360java.com/architecture/7247.html（Eureka常见问题汇总）






<li>相关问题<br>
>1、更新了instanceId，重新，旧instanceId,依然会存在，但过段时间会被清除，以下是日志记录：
<pre>
2017-06-19 10:39:43.561  WARN 7816 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : DS: Registry: expired lease for USER-CENTER/UEX4UMCBLACFA8X:user-center:8888
2017-06-19 10:39:43.569  INFO 7816 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Cancelled instance USER-CENTER/UEX4UMCBLACFA8X:user-center:8888 (replication=false)
</pre>