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

## 报错
### json报错:
数据库中的浮点数强烈建议在pojo中变成String。


### 数据库报错：
1. Client does not support authentication protocol requested by server; consider upgrading MySQL client</br>
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';</br>
FLUSH PRIVILEGES;

2. Unknown initial character set index '255' received from server. Initial client character set can be</br>
直接在连接的URL后加上?useUnicode=true&characterEncoding=utf8就可以了