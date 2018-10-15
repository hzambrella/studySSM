## 版本
jdk 1.7  maven3.2.2 版本不同会各种问题

## 测试
eclipse的tomcat-server就能跑

## 配置

文件名 | 所在目录 | 主要用处 |
---|---|---|---
web.xml |WEB-INF |dispatcherSerlvet和指明spring配置文件  |
[appName]-sevlet.xml| WEB-INF|扫描controller,静态资源处理，拦截器，多媒体文件解析
applicationContext.xml |src/main/resources |扫描Service,POJO,properties,aop |
spring-mybatis.xml |src/main/resources |配置dataSource和sqlSessionFactory|
spring-redis.xml |src/main/resources |配置redis相关|


## 配置文件路径问题
配置文件的路径：
classpath代表 src/main/java,src/main/resources等
在eclipse下的buildpath中设置好<br/>
例子：<br/>
classpath:spring/applicationContext.xml



## 报错处理
### json报错:
数据库中的浮点数强烈建议在pojo中变成String。
Controller接受前端对象json数据时(特别是对象数组)

1.后端导入jackson
2.前端ajax的content-type为application/json

### 数据库报错：
1. Client does not support authentication protocol requested by server; consider upgrading MySQL client</br>
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';</br>
FLUSH PRIVILEGES;

2. Unknown initial character set index '255' received from server. Initial client character set can be</br>
直接在连接的URL后加上?useUnicode=true&characterEncoding=utf8就可以了

3.redis本地密码。如果是windows 直接启动redis-server ，就把密码设置为空即可


## 需求
1.练习mybatis的使用
花式查学生的成绩，花式用户表

2.练习事务--用户购买：<br/>
1.生成订单<br/>
2.查看用户的钱够不够<br/>
3.如果够,将订单状态改为1，并修改用户的金额<br/>
4.如果不够,返回用户余额不足<br/>
5.用户充钱后,执行第二步和第三步。<br/>

第二步和第三步应当构成事务


## 数据表
命名规范：
https://blog.csdn.net/qq_36390239/article/details/80373315

金额单位都是分,int类型

### 学生表

```
-- 学生表
CREATE TABLE `student` (
  `id` int(11) NOT NULL DEFAULT 0',
  `name` varchar(5) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class` (`class_id`)
) ENGINE=InnoDB

```


```
-- 学生课程-成绩表
CREATE TABLE `student_score` (
  `student_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `score` decimal(6,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`student_id`,`subject_id`),
  KEY `score` (`score`)
) ENGINE=InnoDB

```
### 用户表
```
-- 用户表
CREATE TABLE `user_table` (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(8) NOT NULL,
  password varchar(12) NOT NULL default '123456',
  account varchar(12)not null default 'admin',
  -- 1代表男 2代表女
  sex int(11) NOT NULL DEFAULT '1',
  age int(11) NOT NULL,
  tel varchar(10) NOT NULL DEFAULT '',
  addr varchar(30) NOT NULL DEFAULT '',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  money int not null default 0,
  cost int not null default 0,
  PRIMARY KEY (id),
  KEY name (name),
  unique key(account)
) ENGINE=InnoDB


```

```
-- 用户订单表
create table user_order(
	order_id varchar(32) not null,
	user_id int not null,
    good_id int not null,
    number int not null default 0,
    price int not null default 0,
	create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update CURRENT_TIMESTAMP,
    -- 0: 未支付  1:已支付
    status int not null default 0,
    primary key(user_id,order_id,good_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
```
```
-- 商品表
create table user_good(
	id int not null auto_increment,
    shop_id int not null,
    name varchar(40) not null default '',
    -- 单位：分
    price int not null default 0,
    description varchar(200)not null default '',
    icon varchar(100)not null default '',
    primary key(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 AUTO_INCREMENT=10000; 

insert into user_good(shop_id,name,price)
values(1,'无尽之刃',380000),
(1,'血瓶',5000),(1,'真视守卫',7500),(1,'多兰剑',45000),(1,'多兰戒',40500),
(1,'短剑',30000),(1,'长剑',45000),(1,'无用大棒',160000),
(1,'爆裂法杖',85000),(1,'布甲',30000),(1,'荆棘之甲',235000);
select * from  user_good;
```

## ajax返回状态码
在ajax的success函数中，仍然要进行判断。
data.success=true时，为成功。
data.success=false时，为失败，可以显示data.message。

### 成功状态码
状态码 | 含义| 变量
---|---|---
0 | 成功 |Result.Success

### 失败状态码
状态码 | 含义 | 变量
---|---|---
1000 | 用户账号不存在 |User.UserNotFound
1001 | 用户密码错误 |User.UserNotFound
2000 | 生成订单失败 |Order.CreateOrderFail
3000 | 价格数据不统一|Good.GoodPriceNotLatest

## 自定义异常
异常 | 含义 | 所在包
---|---|---
User.MoneyNotEnoughException | 用户余额不足 |User
