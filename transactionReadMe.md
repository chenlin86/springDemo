1.ʲô������
	����ָ�����߼��ϵ�һ�������Ҫôȫ���ɹ���Ҫôȫ��ʧ�ܡ�
2.��������ԣ�
	ԭ���ԡ�һ���ԡ������ԡ��־���
	ԭ������ָ������һ�����ɷָ�Ĺ�����λ�������еĲ���Ҫô��������Ҫô����������
	һ������ָ����ǰ�����ݵ������Ա��뱣��һ��
	��������ָ����û������������ݿ�ʱ��һ���û��������ܱ������û������������ţ������������֮������Ҫ�໥����
	�־�����ָһ������һ�����ύ���������ݿ������ݵĸı��������Եģ���ʹ���ݿⷢ������ҲӦ�ö������κ�Ӱ�졣
3.spring�������
	spring�������߲������Ҫ����3���ӿڣ�
	PlatformTransactionManager ���������
	TransactionDefinition ��������Ϣ(���롢��������ʱ��ֻ��)
	TransactionStatus �����������״̬
	1.PlatformTransactionManager
	springΪ��ͬ�ĳ־ò����ṩ�˲�ͬPlatformTransactionManager�ӿ�ʵ��
	����                                                                                                                            ˵��
	org.springframework.jdbc.datasource.DataSourceTransactionManager ʹ��Spring jdbc����iBatis���г־û�����ʱʹ��
	org.springframework.orm.hibernate3.HibernateTransactionManager   ʹ��Hibernate3.0�汾���г־û�����ʱʹ��
	org.springframework.orm.jpa.JpaTransactionManager                ʹ��JPA���г־û�����ʱʹ��
	org.springframework.jdo.JdpTransactionManager					  ʹ��Jdo���г־û�����ʱʹ��
	org.springframework.transaction.jta.JtaTransactionManager        ʹ��JTAʵ��������������һ�������Խ�����Դʱ����ʹ��
	2.TransactionDefinition
	������뼶��
	�����һ�������ȡ����һ�������д��δ�ύ�����ݣ������Щ����ع������������������Ч�ġ�
	�����ظ�������ͬһ�������У���ζ�ȡͬһ�����ݷ��صĽ��������ͬ��
	�ö���һ�����񣬶�ȡ�˼��м�¼����һ���������һЩ��¼���ö��ͷ����ˡ��ٺ����Ĳ�ѯ�У���һ������ͻᷢ����Щԭ��û�еļ�¼��
	���뼶��                  ����
	default         ʹ�ú�����ݿ�Ĭ�ϵĸ��뼶��(Spring�е�ѡ��)
	read_uncommited �������ȡ��δ�ύ�ĸı��˵����ݣ����ܵ�������������ظ������ö���
	read_commited   �����ڲ��������Ѿ��ύ���ȡ���ɷ�ֹ��������ǲ����ظ������ö���Ȼ�ᷢ����
	repeatable_read ����ͬ�ֶεĶ�ζ�ȡʱһ�µģ��������ݱ�������ı䣬�ɷ�ֹ����������ظ��������ǻö���Ȼ�ᷢ����
	serializable    ��ȫ����ACID�ĸ��뼶��ȷ������������������ظ������ö��������������Ƚ������ǵ��͵�ͨ����ȫ��������������Ƶ����ݱ�����ɵġ�
	MysqlĬ�ϲ���repeatable_read���뼶��OracleĬ�ϲ���read_commited���뼶��
	����Ĵ�����Ϊ��
	���񴫲���Ϊ����                        ˵��
	PROPAGATION_REQUIRED      ֧�ֵ�ǰ������������ھʹ���һ��
	PROPAGATION_SUPPORTS      ֧�ֵ�ǰ������������ڣ��Ͳ���������
	PROPAGATION_MANDATORY     ֧�ֵ�ǰ������������ڣ��׳��쳣
	PROPAGATION_REQUIREES_NEW �������������㣬����ǰ���񣬴���һ���µ�����
	PROPAGATION_NOT_SUPPORTED �Է�����ʽ���У������������ڣ�����ǰ����
	PROPAGATION_NEVER         �Է�����ʽ���У������������ڣ��׳��쳣
	PROPACATION_NESTED        �����ǰ������ڣ���Ƕ������ִ��
4.spring�������
	���ʽ�������--��ʵ��Ӧ���к���ʹ�ã�ͨ��transactionTemplate�ֶ���������
	ʹ��xml��������ʽ�������--�������Ƽ�ʹ��(������������С)��spring������ʽ������ͨ��APOʵ�ֵ�
	





















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
