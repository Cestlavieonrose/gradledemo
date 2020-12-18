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



