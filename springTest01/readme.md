实现步骤：
1.创建maven项目
2.加入maven的依赖
  spring的依赖，版本5.2.5版本
  junit依赖
3.创建类（接口和他的实现类）
  和没有使用框架一样， 就是普通的类。
4.创建spring需要使用的配置文件
  声明类的信息，这些类由spring创建和管理
5.测试spring创建的。


di：依赖注入，表示创建对象，给属性赋值。

di的实现有两种：
1.在spring的配置文件中， 使用标签和属性完成，叫做基于XML的di实现
2.使用spring中的注解，完成属性赋值， 叫做基于注解的id实现

di的语法分类：
 1. set注入（设置注入）： spring调用类的set方法，在set方法可以实现属性的赋值。
    80%左右都是使用的set注入
 2. 构造注入，spring调用类的有参数构造方法，创建对象。在构造方法中完成赋值。
 
    简单类型： spring中规定java的基本数据类型和String都是简单类型。
 di:给属性赋值
  1. set注入（设值注入） ：spring调用类的set方法， 你可以在set方法中完成属性赋值
   1）简单类型的set注入
     <bean id="xx" class="yyy">
        <property name="属性名字" value="此属性的值"/>
        一个property只能给一个属性赋值
        <property....>
     </bean>
   2) 引用类型的set注入 ： spring调用类的set方法
    <bean id="xxx" class="yyy">
       <property name="属性名称" ref="bean的id(对象的名称)" />
    </bean>
    
  2.构造注入：spring调用类有参数构造方法，在创建对象的同时，在构造方法中给属性赋值。
   构造注入使用 <constructor-arg> 标签
   <constructor-arg> 标签：一个<constructor-arg>表示构造方法一个参数。
   <constructor-arg> 标签属性：
      name:表示构造方法的形参名
      index:表示构造方法的参数的位置，参数从左往右位置是 0 ， 1 ，2的顺序
      value：构造方法的形参类型是简单类型的，使用value
      ref：构造方法的形参类型是引用类型的，使用ref
      
      
 引用类型的自动注入： spring框架根据某些规则可以给引用类型赋值。·不用你在给引用类型赋值了
        使用的规则常用的是byName, byType.
        1.byName(按名称注入) ： java类中引用类型的属性名和spring容器中（配置文件）<bean>的id名称一样，
                               且数据类型是一致的，这样的容器中的bean，spring能够赋值给引用类型。
          语法：
          <bean id="xx" class="yyy" autowire="byName">
             简单类型属性赋值
          </bean>
        2.byType(按类型注入) ： java类中引用类型的数据类型和spring容器中（配置文件）<bean>的class属性
                       是同源关系的，这样的bean能够赋值给引用类型
        同源就是一类的意思：
        1.java类中引用类型的数据类型和bean的class的值是一样的。
        2.java类中引用类型的数据类型和bean的class的值父子类关系的。
        3.java类中引用类型的数据类型和bean的class的值接口和实现类关系的
        语法：
        <bean id="xx" class="yyy" autowire="byType">
          简单类型属性赋值
        </bean>
        
 
3、多个配置文件
	1.按功能模块划分
	2.按类的功能，数据库相关的配置一个文件配置文件， 做事务的功能一个配置文件， 做service功能的一个配置文件等
        包含关系的配置文件：
        spring-total表示主配置文件 ： 包含其他的配置文件的，主配置文件一般是不定义对象的。
        语法：<import resource="其他配置文件的路径" />
        关键字："classpath:" 表示类路径（class文件所在的目录），
            在spring的配置文件中要指定其他文件的位置， 需要使用classpath，告诉spring到哪去加载读取文件。
       
        <!--加载的是文件列表-->  
        <import resource="classpath:ba06/spring-school.xml" />
        <import resource="classpath:ba06/spring-student.xml" />
        
        在包含关系的配置文件中，可以通配符（*：表示任意字符）
        * 注意： 主的配置文件名称不能包含在通配符的范围内（不能叫做spring-total.xml）
        <import resource="classpath:ba06/spring-*.xml" />