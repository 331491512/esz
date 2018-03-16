# 合并业务框架代码编写规范

## service层 合并业务核心实现
0. 统一放到: com.esuizhen.bigdata.merge.impl包中。 该包是可以配置的.
1. 统一命名约定为 Merge[JavaBean]Service,例如UPatient->MergeUPatientService
1. 继承AbstractMergeBean.
2. 业务参数实例构造时反射注入，方法中不需要再重复写，直接调用即可.
3. MergeService类为主调度类，通过命令模式调度执行合并业务队列

## dao层  数据操作模块
0. 接口统一放在 com.esuizhen.bigdata.repository
1. 自定义接口实现统一放在 com.esuizhen.bigdata.repository.impl
2. 在具体合并实现中增加实现接口 实现注入   MergeUPatientService构造方法中手动注入
```
@Component
@RepositoryRestController
@Transactional
public interface UPatientRepository extends JpaRepository<UPatient, Long>, RevisionRepository<UPatient, Long, Integer> {}
```
## controller层 [因为只是后台数据服务，其实是可以省略的，这层加上为了更细粒度而不是直接使用RestResourceRepository]
