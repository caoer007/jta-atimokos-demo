 建表语句

 CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
 )ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
 
 访问路径参考：localhost:8080/cc/test/xaTest.do
 项目访问名取决于自己tomcat中配置的ApplicationContext 是什么
 传入参数：mode  1 回滚数据 非1 不回滚 位置HttpRequest中





