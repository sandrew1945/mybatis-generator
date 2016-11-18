MyBatis Generator (MBG)
=======================

[![Build Status](https://travis-ci.org/mybatis/generator.svg?branch=master)](https://travis-ci.org/mybatis/generator)
[![Coverage Status](https://coveralls.io/repos/mybatis/generator/badge.svg?branch=master&service=github)](https://coveralls.io/github/mybatis/generator?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/561964c6a193340f2800033c/badge.svg?style=flat)](https://www.versioneye.com/user/projects/561964c6a193340f2800033c)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis.generator/mybatis-generator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis.generator/mybatis-generator)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

![mybatis-generator](http://mybatis.github.io/images/mybatis-logo.png)

Code generator for MyBatis and iBATIS.

It will generate code for all versions of MyBatis, and versions of iBATIS after version 2.2.0. It will introspect a database table (or many tables) and will generate artifacts that can be used to access the table(s). This lessens the initial nuisance of setting up objects and configuration files to interact with database tables. MBG seeks to make a major impact on the large percentage of database operations that are simple CRUD (Create, Retrieve, Update, Delete).


修改记录：
2016-11-18
1、修改InnerClass类，增加actualTableName字段，用来保存要生成的表的真实表名，用来添加表名注解

2、修改InnerClass类的getFormattedContent方法，增加真实表名的注解

3、修改DatabaseIntrospector类的calculateIntrospectedTables方法，判断domainObjectName是否填写，如果为空那么根据表名生成

4、修改Field类，增加actualColumnName，用来生成列名注解

5、修改JavaBeansUtil类的getJavaBeansField方法，将真实列名存入Field中

6、修改BaseRecordGenerator类的getCompilationUnits方法，将表的真实表名存入TopLevelClass(InnerClass、CompilationUnits)中

7、新增TableUtil类，PO类名与表名转换工具类
