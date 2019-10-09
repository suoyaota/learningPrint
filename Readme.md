* 使用了ECharts中的日历图，可以记录每天的学习小时数以及标志性的学习成就事件。

* 当然也可以记录别的事情。

### 项目运行方法

1. 使用doc中的ddl.sql建表。
2. 修改src\main\resource\application.yml 中的server:port端口号为你的Tomcat端口号，再把链接数据库的用户名和密码改为你的。
3. 运行src\main\java\com\wyb\footprint\FootprintApplication.java中的主方法，打开浏览器访问localhost即可使用。