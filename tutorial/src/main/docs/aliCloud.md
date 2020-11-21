# Ali Cloud

##SLB - Server Load Balancer 

####SLB功能架构
1. Load Balancer - 代表SLB实例
2. Listener - 代表定制的策略和转发规则
3. Backend Server - 后端的一组云服务器

####SLB基础架构
1. 四层负载均衡 - TCP/UDP
2. 七层负载均衡 - http/https
3. 控制系统 - 配置/监控 负载均衡系统

####SLB主要功能
1. 四层负载均衡/七层负载均衡 - 支持公网及私网（私网免费使用）
2. 健康检查 - 屏蔽不健康的实例，待实例恢复正常解除屏蔽
3. 会话保持 - session生命周期内，统一客户端的请求都转发到同一ECS
在·4. 转发方式 - 轮询（依次发送）/加权轮询（可为后端ecs设置权重）/加权最小连接数（请求转发到连接数最少的ecs） / 一致性哈希（源IP-相同的原地址会指向同一ECS/四元组-源IP，目的ip，源端口，目标端口，相同的流会指向同一ECS）
5. 证书管理 - https的证书解密放在SLB上，降低ECS的开销
6. 带宽控制 - 根据监听设置对应服务的带宽峰值
7. 容灾 - 支持同一地域（region）跨可用区容灾，结合DNS轮询支持跨地域的容灾
8. 控制方式 - 控制台/api/sdk

####SLB费用
1. 计费模式 - 预付费（按带宽，只支持升级,不支持降级或者释放）/后付费 （按固定带宽/按流量），可随时释放
2. 总费用 - 实例配置费 + 公网带宽费
3. 公网SLB和ECS之间的流量费 - 不收取费用

####监听概述
#####TCP监听
1. 面向连接的协议，在正式收发数据前，必须和对方建立可靠的连接
2. 基于源地址的会话保持
3. 在网络层可直接看到来源地址
4. 数据传输快
5. 适用于注重可靠性，对数据准确性要求高，速度可以相对较慢的场景，如文件传输、发送或接收邮件、远程登录
6. 无特殊要求的Web应用 （web应用都是基于http/https的）
7. TCP监听 - 支持tcp及http两种方式进行健康检查

#####UDP
1. 面向非连接的协议，在数据发送前不与对方进行三次握手，直接进行数据包发送，不提供差错恢复和数据重传 
2. 可靠性相对低；数据传输快
3. 关注实时性而相对不注重可靠性的场景，如视频聊天、金融实时行情推送

#####HTTP
1. 应用层协议，主要解决如何包装数据
2. 基于Cookie的会话保持
3. 使用X-Forward-For获取源地址
4. 需要对数据内容进行识别的应用，如Web应用、小的手机游戏等。

#####HTTPS
1. 加密传输数据，可以阻止未经授权的访问
2. 统一的证书管理服务，用户可以将证书上传到负载均衡，解密操作直接在负载均衡上完成
3. 需要加密传输的应用。

#####SLB监听超时时间
1. TCP - 900秒
2. UDP - 90秒
3. HTTP - 60秒
4. HTTPS - 60秒


##ECS - Elastic Compute Service 
ECS支持切换交换机 但不支持切换路由器
ECS上停止是走正常关机流程，而强制停止则等于断电处理，可能会丢失信息
ECS管理控制台直接支持的功能不包括 迁移实例
ECS在更换系统盘的时候，镜像是可以修改的


##Points


安全管家 支持人工安全技术支持，托管报告服务
安骑士 可以检测并修复漏洞
云盾DDos是保障ECS/SLB/WAF/VPC/EIP/NAT云产品的网络安全，并不包括RDS/OSS

ECS转备用状态，则负载均衡不会有流量到，弹性伸缩不会检查此ecs，但也不会释放这个ecs
ECS转保护状态，则弹性伸缩不会移除这个ECS，负载均衡权重不变（有流量到），弹性伸缩页不会检查此ecs，但也不会释放这个ecs
VNC方式登录 1：实例自检原因导致启动速度慢 2：误操作开启了防火墙 3：ecs cpu带宽消耗高
阿里云会保存SSH key的公钥部分
弹性公网IP（EIP）秒级监控
更换系统盘后，旧系统盘会被释放，系统盘id会更新，自动快照策略不一定失效
SLB的虚拟服务器组如果添加了该ecs，该ecs从经典网络迁移到vpc时，实例不会自动挂载
本地盘，很多操作都不行
弹性伸缩生命周期挂钩支持的配置方式不包括OSS主板 
交换机（VSwitch）不支持组播和广播
将bucket设置成静态网页托管模式后，对静态网站域名的匿名访问 oss将返回索引页；对静态网站根域名的访问 oss将返回GetBucket结果
OSS同城冗余能够提供机房级别的容灾能力
OSS低频访问类型存放是平均每月访问1-2次的数据，归档存储类型是放每年访问1-2次的数据

某个VPC的网络附加ipv4是172.16.0.0/16，那么该vpc的交换机可选网段为172.16.0.0/17 - 172.16.0.0/29
网络ACL的规则是无状态的
SLB后端的ecs操作系统不一定需要一致
CDN实际产生的流量比应用层统计到的要高。是两个原因 1： TCP/IP的包头的消耗 2：TCP重传
创建EIP之后，云监控服务自动开启
在冷却时间内，伸缩组会拒绝由云监控发起的伸缩活动请求，对其他的类型的任务则会立即执行，绕过冷却时间
公网分发请求到SLB的方法 1：购买公网ip的负载均衡SLB实例接受公网请求 2：创建VPC内的负载均衡实例，然后给这个SLB绑定EIP来接收公网请求

