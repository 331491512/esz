【开发约定，请注意！】
merge模块，定义impl包为具体合并实现类所在部分。
该包下的都将继承abstractMergeBean，有三个抽象行为，可以根据情况，具体实现。
并且通过命令模式统一调用，该包路径已经配置在配置文件下。

# 合并业务框架代码编写规范 参见src/README.md

注:2017/1/9 该开发模式是之前的架构考虑，新版本后该模式将重构为典型的模式...