# SpringBootDemo
_**`Spring Boot整合MyBatis,并使用Swagger2构建的RESTful API文档`**_

**导读**
Application.java放到根目录下面,主要用于做一些框架配置：
1、domain层主要用于实体（Entity）与数据访问层（Repository）,
2、service层主要是业务类代码,
3、web层主要负责页面访问控制,
4、utils层主要存放工具类,例如统一异常处理类,统一返回类型类,以及日志类。

**使用Swagger2**
Swagger2可构建强大的RESTful API文档。
创建Swagger2配置类：
在Application.java同级创建Swagger2的配置类Swagger2。
访问：http://localhost:8080/swagger-ui.html,就能看到前文所展示的RESTful API的页面。

**结合单元测试**
使用JUnit4进行单元测试。

**整合MyBatis**
Spring Boot采用了注解的配置方式整合MyBatis。

**统一异常处理**
GlobalExceptionHandler类通过使用@ControllerAdvice定义统一的异常处理类,可在类中定义异常信息返回到HTML页面或者Json数据。
MyException工具类对异常类型进行了规定。
error.ftl为统一异常返回页面HTML模板。

**统一返回类型**
MessageVo工具类对接口返回类型进行了规定。
String code 定义返回处理结果编码,
String info 定义返回处理结果编码所代表的信息,
Object data 定义返回逻辑处理后所得到的数据。

**log4j日志**
WebLogAspect工具类采用AOP编程对web层的访问进行日志记录。

**NOSQL数据库Redis**
Redis是一个可基于内存亦可持久化的日志型、Key-Value数据库。
