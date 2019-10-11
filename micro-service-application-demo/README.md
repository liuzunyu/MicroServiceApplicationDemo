#标准的REST API工程框架
## 目录结构
- main目录：api代码
- test目录：测试用例

以上两个目录在任何工程中必须存在，不允许不编写测试用例

- resources：资源和配置文件所在的目录，使用yml文件来代理properties

# 代码中包的命名
原则上，所有工程的包以：`com.jdcloud.项目名.模块名`作为根目录。在代码的大类上，按照`controller`、`model`、`dao`和`service`分别存放各层的类。
代码中用到的其它类所在的包名称不限，但是请最好能有一个清晰的结构

# 构建中group和artifact名
原则上，工程的构件所属的以：`com.jdcloud.项目名`作为前缀，如果在项目中明确划分了子产品线，则构件组附加子产品线的名称。
构件和组的名称请使用小写字母，单词间通过'-'连接。

# 已经内置的组件
- 标准响应：http://git.jd.com/one-man-army/code/blob/master/%E6%A0%87%E5%87%86%E5%8C%96%E7%BB%84%E4%BB%B6%E7%A0%94%E5%8F%91%E7%BA%BF/%E6%95%B0%E6%8D%AE%E6%A8%A1%E5%9E%8B%E6%A0%87%E5%87%86%E5%8C%96%E4%B8%9A%E5%8A%A1%E7%BA%BF/standard-response/README.md
- 针对controller异常的标准化处理流程：http://git.jd.com/one-man-army/code/blob/master/%E6%A0%87%E5%87%86%E5%8C%96%E7%BB%84%E4%BB%B6%E7%A0%94%E5%8F%91%E7%BA%BF/%E5%B7%A5%E5%BA%8F%E6%A0%87%E5%87%86%E5%8C%96%E4%B8%9A%E5%8A%A1%E7%BA%BF/controller-exception-handler-delegate/README.md

#vpc-core-service介绍
## build.gradle
- dependencies {}：在这里引入vpc的sdk
- mybatisGenerate：这个方法是用来从数据库生成mapper和entity的
## config.groovy
- 这个文件对应各个环境的变量，编译时会根据profile动态写入
## JdcloudClientService
- 在这个类里去创建各个服务SDK调用的Client，如本例的VpcClient
- 这个里面会用到aksk、资源池pin以及sdk的网关host
## JdcloudVpcService
- 在这个里面处理对sdk的各种调用以及数据库操作，就不多说了
## Controller
- pin：这个参数是在zuul里解析出来的用户名，用来入中台数据库或者是做一些比对，如果不通过zuul调用，直接调用api本身的话需要指定这个参数
- 前端传json
## 几个openapi&sdk的git
- http://git.jd.com/jcloud-api-gateway/jcloud-open-api-doc/blob/internal/Virtual-Private-Cloud/Virtual-Private-Cloud/describeVpc.md
- http://git.jd.com/jcloud-api-gateway/jcloud-sdk-java/tree/internal/vpc/src/main/java/com/jdcloud/sdk/service/vpc/client