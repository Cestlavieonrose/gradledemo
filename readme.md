
- [1. gradle安装与环境配置](#1-gradle安装与环境配置)
	- [1.1. mac](#11-mac)
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
def c1 = {
	v ->
		print v
}

def c2 = {
	print 'hello'
}

def method1(Closure c) {
	closure('param')
}

def method2(Closure c) {
	closure()
}

method1 c1
method2 c2

```

