
- [1. gradle安装与环境配置](#1-gradle安装与环境配置)
	- [1.1. mac](#11-mac)
- [Gradle简介](#gradle简介)
	- [特性](#特性)
	- [构建三个阶段](#构建三个阶段)
	- [task](#task)
	- [关键字](#关键字)
	- [常用命令](#常用命令)
- [2. Groovy](#2-groovy)
	- [2.1. 基本介绍](#21-基本介绍)


------------


# 1. gradle安装与环境配置

## 1.1. mac

1. 编辑bash_profile文件：
```shell
	vi ~/.bash_profile
```
2. 加入以下内容
```shell
#gradle
GRADLE_HOME=/usr/local/gradle-5.4.1
PATH=$PATH:$GRADLE_HOME/bin
export GRADLE_HOME GRADLE_USER_HOME PATH
```
3. 执行下面命令使内容生效：
```shell
source ~/.bash_profile
```
4.测试安装是否成功：
```shell
gradle -v
```

# Gradle简介
## 特性
1. 两个概念：project，task
2. 每一个构建至少包含一个陪project，每个build.gradle就是一个project
3. 每个project至少包含1到多个task，task包含若干个个**动作对象**，一个动作对象就是一个待执行的代码块，类似java的方法
## 构建三个阶段
1. Initialization：gradle决定将那些project参与到构建，并为每一个project创建一个Project实例，参与构建的project信息在settings.gradle中定义
2. Configuration：配置project实例，所有project脚本都将被执行。Task，configuration和许多其他对象将被创建和配置
3. Execution：task依此被执行
## task
1. task可以依赖其他task
2. task不能相互依赖
## 关键字
1. doLast:里面的代码块在第三阶段执行

## 常用命令
1. `gradle` ：只执行到第二阶段
2. `gradle -q taskname`：执行到第三阶段，静默执行某个task，也就是只打印错误日志，不打印其他日志



# 2. Groovy

## 2.1. 基本介绍

1. 运行在jvm上的一种脚本语言
2. 完全兼容java语法
3. 分号可选
4. 类和方法默认都是public
5. 自动给属性添加getter/setter方法
6. 最后一个值作为返回值 不需要写return
7. ==等效equal
8. 弱类型
9. 方法括号可选
10. 字符串可以单引号和双引号
11. 集合api
>示例：
```groovy

//弱类型 代码结尾；可以不写
def version = 2
//字符串
def s1 = 'test'
def s2 = "hello ${version}"
def s3 = '''
hello
my name is anna
i'm 4 years old
'''
//方法括号可选
println(s1)
println s2

//集合api
def buildTools = ['ant', 'maven']
buildTools << 'gradle'
//断言
asset buildTools.getClass() == ArrayList
asset buildTools.size() == 3

//map
def buildYears = ['ant':2000, 'maven':2004]
buildYears.gradle = 2009

println buildYears.ant
println buildYears['gradle']
asset buildYears.getClass() == LinkedHashMap

//closure
//带参闭包
def c1 = {
	v ->
		print v
}

def c2 = {
	print 'hello'
}

//方法中当成参数
def method1(Closure c) {
	closure('param')
}

def method2(Closure c) {
	closure()
}

method1 c1
method2 c2

//单个隐参数
def cols3={
            println "Hello ${it}"
        }
cols3("二狗")

//each 遍历
[1,2,3,4,5].each { println it}
['张三':100,'李四':200,'王五':300].each { println it.key+":"+it.value}
//find方法返回集合中符合某个判断标准的第一个值，在闭包中，集合元素使用的判断条件必须是bool表达式
def num = [1,2,3,4].find{p->p>2}
println num
//findAll方法是遍历所有的元素并返回一个符合条件的列表
map = ['张三':100,'李四':200,'王五':300].findAll {it.value>100}
println map
//collect将遍历某个集合，并使用闭包中的变换方法将集合中的元素转换成一个新值，collect方法返回的是由转换后的值所组成的列表
def  staff= ["李铭":10,"李浩":20,"二狗":50]
list=staff.collect {e->++e.value}
println "staff:${list}"
staff = staff.collect {e->++e.value;return e}
println staff

//inject可用于遍历集合，首先将需要传递的值和集合中遍历出来的元素传给闭包，此时其传递的值将作为一个处理结果然后在和下一个集合元素一起传给闭包，依次类推
def factories = [2,3,4,5].inject(1){p,e->p*e}
println "factories1:${factorials}"
list = [2,3,4,5]
def clos6 = {p,e->p*e}
factories = list.inject (1,clos6)
println "factories2:${factories}"

```


