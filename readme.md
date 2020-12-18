gradle安装与环境配置
=========
mac
--------
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

Groovy
=======
基本介绍
------
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
>示例：
```groovy
def version = 2
def s1 = 'test'
def s2 = "hello ${version}"
def s3 = '''
hello
my name is anna
i'm 4 years old
'''
```





