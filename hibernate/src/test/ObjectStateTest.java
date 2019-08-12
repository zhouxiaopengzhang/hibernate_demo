package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Teacher;

public class ObjectStateTest {
	Configuration conf=null;
	SessionFactory factory=null;
	Session session=null;
	Transaction transacation=null;
	@Before
	public void persistentTestBefore(){
		//创建configuration
		conf=new Configuration();
		//读取配置文件
		conf.configure();
		//创建一个SessionFactory工厂类
		factory=conf.buildSessionFactory();
		//通过工厂开启Session对象
		session=factory.openSession();
		//开始事务
		transacation=session.beginTransaction();
	}
	@Test
	public void  selectTest(){
		//new一个对象t，该对象就为瞬时态，给其设置属性值也为瞬时状态，一旦给主键赋值就不是瞬时态
		Teacher t=new Teacher();
		t.setName("李四");
		//通过save或saveOrUpdate方法将t转换为持久化对象
		session.save(t);
	}
	@After
	public void selectTestAfter(){
		//提交事务方式1
	//	transacation.commit();
		//关闭session，在关闭session之前会检测事务是否已开启，若有开启则将提交事务
	//	session.close();	//提交事务方式2
		//关闭工厂类：在web应用中不需要关闭工厂类
	//	factory.close();
	}
}
