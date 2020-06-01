# jeekite-pro
jeekite-pro是集合代码生成器生成后端的java代码，不需要重复写增删改查，只需要数据库中存在相应的表就好
jeekite-pro目前只是在开发阶段，前端打算采用vue脚手架来开发，后端技术springboot+springcloud+springredis+springrabbitmq+elsearch的主要技术实现
使用方式：
git下载代码： https://github.com/dwx617676/jeekite-pro.git
导入idea  运行jeekite-online中的Code.java文件就可以生成代码


application-dev.yml
1.数据源
2.修改dao、service、serviceimpl、model、controller包路径
3.默认开启了swagger，可以关闭
4.自定义模板
    resources/template：模板跟路径
    controller/Controller.java      控制层模板
    dao/Mapper.java                 Dao层模板
    pojo/Pojo.java                  Model模板
    service/Service.java            业务层接口模板
    service/impl/ServiceImpl.java   业务层接口实现类模板

  注意：模板的配置遵循Freemarker指令规范。

5.数据模型对应的key和说明
    table:表名，小写开始，去掉了tab_,tb_,_转驼峰
    Table:表名，大写开始，去掉了tab_,tb_,_转驼峰
    swagger:是否启用swagger，true：启用，false：关闭
    TableName:表的真实名字
    models:JavaBean的所有属性信息
    typeSet:JavaBean的所有类型Set集合
    keySetMethod:主键的set方法，例如 setId,这里没有加括号
    keyType:主键的类型，例如Long，这里没有权限定包路径
    package_controller:控制层包路径
    package_pojo:pojo包路径
    package_mapper:dao包路径
    package_service:service接口包路径
    package_service_impl：serviceImpl实现类包路径

6.多条件搜索时，如果属性名字包含name、title，则会进行like模糊搜索
