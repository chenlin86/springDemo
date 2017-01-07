1.什么是事务？
	事务指的是逻辑上的一组操作，要么全部成功，要么全部失败。
2.事务的特性：
	原子性、一致性、隔离性、持久性
	原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
	一致性是指事务前后数据的完整性必须保持一致
	隔离性是指多个用户并发访问数据库时，一个用户的事务不能被其他用户的事务所干扰，多个并发事务之间数据要相互隔离
	持久性是指一个事务一旦被提交，它对数据库中数据的改变是永久性的，即使数据库发生故障也应该对其有任何影响。
3.spring事务管理
	spring事务管理高层抽象主要包括3个接口：
	PlatformTransactionManager 事务管理器
	TransactionDefinition 事务定义信息(隔离、传播、超时、只读)
	TransactionStatus 事务具体运行状态
	1.PlatformTransactionManager
	spring为不同的持久层框架提供了不同PlatformTransactionManager接口实现
	事务                                                                                                                            说明
	org.springframework.jdbc.datasource.DataSourceTransactionManager 使用Spring jdbc或者iBatis进行持久化数据时使用
	org.springframework.orm.hibernate3.HibernateTransactionManager   使用Hibernate3.0版本进行持久化数据时使用
	org.springframework.orm.jpa.JpaTransactionManager                使用JPA进行持久化数据时使用
	org.springframework.jdo.JdpTransactionManager					  使用Jdo进行持久化数据时使用
	org.springframework.transaction.jta.JtaTransactionManager        使用JTA实现来管理事务，在一个事务跨越多个资源时必须使用
	2.TransactionDefinition
	事务隔离级别
	脏读：一个事务读取了另一个事务改写还未提交的数据，如果这些数别回滚，则读到的数据是无效的。
	不可重复读：在同一个事务中，多次读取同一个数据返回的结果有所不同。
	幻读：一个事务，读取了几行记录后，另一个事务插入一些记录，幻读就发生了。再后来的查询中，第一个事务就会发现有些原来没有的记录。
	隔离级别                  含义
	default         使用后端数据库默认的隔离级别(Spring中的选项)
	read_uncommited 允许你读取还未提交的改变了的数据，可能导致脏读、不可重复读、幻读。
	read_commited   允许在并发事务已经提交后读取，可防止脏读，但是不可重复读、幻读仍然会发生。
	repeatable_read 对相同字段的多次读取时一致的，除非数据被事务本身改变，可防止脏读，不可重复读，但是幻读仍然会发生。
	serializable    完全服从ACID的隔离级别，确保不发生脏读，不可重复读，幻读。但是这个隔离比较慢，是典型的通过完全锁定在事务中设计的数据表来完成的。
	Mysql默认采用repeatable_read隔离级别，Oracle默认采用read_commited隔离级别。
	事务的传播行为：
	事务传播行为类型                        说明
	PROPAGATION_REQUIRED      支持当前事务，如果不存在就创建一个
	PROPAGATION_SUPPORTS      支持当前事务，如果不存在，就不适用事务
	PROPAGATION_MANDATORY     支持当前事务，如果不存在，抛出异常
	PROPAGATION_REQUIREES_NEW 如果有事务存在你，挂起当前事务，创建一个新的事务
	PROPAGATION_NOT_SUPPORTED 以非事务方式运行，如果有事务存在，挂起当前事务
	PROPAGATION_NEVER         以非事务方式运行，如果有事务存在，抛出异常
	PROPACATION_NESTED        如果当前事务存在，则嵌套事务执行
4.spring事务管理
	编程式事务管理--在实际应用中很少使用，通过transactionTemplate手动管理事务
	使用xml配置声明式事务管理--开发中推荐使用(代码侵入性最小)，spring的声明式事务是通过APO实现的
	





















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
