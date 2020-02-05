# 利用亚马逊云AWS EC2 免费搭建SS

1、背景
科学上网是现在很多人所需要的，尤其是需要上Google、Facebook等。新手不建议直接买VPN，个人认为购买VPS搭建自己的海外服务器比较靠谱。然而，购买VPS肯定需要从免费的入手，首推AWS和Google Cloud Platform。前提是得有信用卡。

VPN：在公用网络上建立专用网络，进行加密通讯。在企业网络中有广泛应用。VPN网关通过对数据包的加密和数据包目标地址的转换实现远程访问。VPN有多种分类方式，主要是按协议进行分类。VPN可通过服务器、硬件、软件等多种方式实现。
VPS：Virtual Private Server 虚拟专用服务器技术，将一台服务器分割成多个虚拟专享服务器的优质服务。实现VPS的技术分为容器技术，和虚拟化技术。简单理解VPS就是一台拥有公网IP的服务器。
AWS：即Amazon Web Services，是亚马逊（Amazon）公司的云计算IaaS和PaaS平台服务。
�0�2
2、注册AWS
到AWS进行注册。注册过程中需要绑定信用卡，会扣$1(预授权)。但需要注意的是，在没有用超的情况下，是免费的，作为SS服务器，只能是流量超额会导致（15GB/月）。注册过程中，需要填写手机号，会有国际长途（手机号默认开通）打进来，告诉你验证码。

3、创建AWS实例
1、登录AWS控制台，点击EC2（Elastic Compute Cloud）
EC2
备注：第一次开通需要时间，最长不超过24小时。

开通AWS

2、启动虚拟机
启动虚拟机

启动实例
这里，点击高级EC2启动实例向导进行个性化配置。

3、定制化服务器类型
选择Amazon 系统映像(AMI)
这里选择，Amazon Linux AMI、RedHat、Ubuntu都行。本文选择的是Ubuntu。
AMI

选择实例类型

实例类型

标签实例
图中标出的3-4两步直接默认配置就行。
image.png

配置安全组�0�2�0�2�0�2 //这一步很重要， 不然用SSH客户端PuTTY / Xshell 连接不上
这里先配置所有流量和端口开放。�0�2 // 也可以设置自定义TCP规则， 端口分别设置为 5555 1194 443 992 8888 等 来源可设置为 任何位置
配置安全组

生成秘钥对
审核

创建账单警报
账单警报.png

接收账单警报

3、登录服务器
定制完成后，就可以远程登录了。在实例上右击，点击连接。
连接

连接到实例

下面主要是通过Xshell连接到EC2，具体看教程。注意：用户名那里填写ubuntu，否则会出现所选的用户密钥未在远程主机上注册 请再试一次。

4、安装Shadowsocks
# 获取root权限
sudo -s
# 更新apt-get
apt-get update
# 安装python包管理工具
apt-get install python-setuptools
apt-get install python-pip
# 安装shadowsocks
pip install shadowsocks
5、配置Shadowsocks
在终端输入

ssserver -h
查看Shadowsocks的帮助，适合进阶玩家。

如果提示没有ssserver这个命令，可以通过

which ssserver
查看Shadowsocks的路径，一般是在/usr/local/bin目录下，我们只需要把/usr/local/bin加入到/etc/profile文件中即可。

也可以通过

/usr/local/bin/ssserver
来执行相应的命令。

例如查看帮助为

/usr/local/bin/ssserver -h
创建配置文件
mkdir /etc/shadowsocks
vim /etc/shadowsocks/ss.json
配置文件内容：

{
    "server":"0.0.0.0",
    "server_port":443, //ss连接服务器的端口
    "local_address":"127.0.0.1",
    "local_port":1080,
    "password":"abcd1234", // 设置ss连接时的密码
    "timeout":300,
    "method":"aes-256-cfb",
    "fast_open":false,
    "workers": 1
}
配置字段	说明
server	服务端监听地址(IPv4或IPv6)
server_port	服务端端口，一般为443
local_address	本地监听地址，缺省为127.0.0.1
local_port	本地监听端口，一般为1080
password	用以加密的密匙
timeout	超时时间（秒）
method	加密方法，默认为aes-256-cfb，更多请查阅Encryption
fast_open	是否启用TCP-Fast-Open，true或者false
workers	worker数量
6、启动Shadowsocks
启动：sudo /usr/local/bin/ssserver -c /etc/shadowsocks/ss.json -d start

停止：sudo /usr/local/bin/ssserver -c /etc/shadowsocks/ss.json -d stop�0�2
重启：sudo /usr/local/bin/ssserver -c /etc/shadowsocks/ss.json -d restart
7、设置SS为开机自启动
sudo vi /etc/rc.local
在rc.local文件末尾添加以下代码：

sudo /usr/local/bin/ssserver -c /etc/shadowsocks/ss.json -d start
�0�2
8、本地设备连接到Shadowsocks服务器
到GitHub下载最新的客户端：
Windows客户端下载地址
macOS客户端下载地址
Linux客户端下载地址

安装之后，添加服务器，地址为AWS的外网地址，登录AWS控制台，查看正在运行中的实例，找到公有ip。 端口号为刚才配置Shadowsocks服务器时的端口号，密码也是刚才配置的(当然密码可以自行设置)，设置完之后保存。

关于Windows下使用Shadowsocks的方法，还请自行搜索。

9、防止AWS到期或其他原因扣费
为了防止流量超出或者此悲剧发生。
需要设置账单警报，前面已经介绍了。
还有就是在安全组下面设置入站和出站规则。
一言以蔽之，到期前把你账户下所有AWS实例关闭并销毁

***

## mac connect to vm
```sh
ssh -i ~/.ssh/vitaaws.pem ubuntu@ec2-18-191-33-62.us-east-2.compute.amazonaws.com
```
