## 版本
jdk 1.7  maven3.2.2 版本不同会各种问题

## 测试
eclipse的tomcat-server就能跑

## 配置
spring的配置文件名是dispatcherSerlvet 的servlet名-servlet.xml,在WEB-INF文件夹下

web.xml下有dispatcherSerlvet 

spring.xml下
1.SpringMVC:
有要扫瞄注解的包，拦截器，视图解析器internalResourceViewResolver，可以是jsp freeMaker，
静态资源文件resource  读取配置文件PropertyPlaceholderConfigurer

2.mybatis:
dataSource

## 配置文件路径问题
配置文件的路径：
classpath代表 src/main/java,src/main/resources等
在buildpath中设置好

web.xml ContextListener
classpath*:spring/applicationContext.xml

applicationContext.xml
properties:
classpath:properties/mysql.properties
sqlSessionFactory:
classpath:mybatis/mybatis.xml

mybatis.xml:
```
	<mappers>
		<mapper resource="mybatis/mapper_student.xml" />
		<mapper resource="mybatis/mapper_user.xml" />
	</mappers>
```

## 报错
### json报错:
数据库中的浮点数强烈建议在pojo中变成String。


### 数据库报错：
1. Client does not support authentication protocol requested by server; consider upgrading MySQL client</br>
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';</br>
FLUSH PRIVILEGES;

2. Unknown initial character set index '255' received from server. Initial client character set can be</br>
直接在连接的URL后加上?useUnicode=true&characterEncoding=utf8就可以了




## 需求
花式查学生的成绩

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) NOT NULL,
  -- 1代表男 2代表女
  `sex` int(11) NOT NULL DEFAULT '1',
  `age` int(11) NOT NULL,
  `tel` varchar(10) NOT NULL DEFAULT '',
  `addr` varchar(30) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  money int not null default 0,
  cost int not null default 0,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB


```

```
-- 用户订单表
create table user_order(
	order_id varchar(12) not null,
	user_id int not null,
    good_id int not null,
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