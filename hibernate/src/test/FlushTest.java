package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Teacher;

public class FlushTest {
	Configuration conf=null;
	SessionFactory factory=null;
	Session session=null;
	Transaction transacation=null;
	@Before
	public void selectTestBefore(){
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
		//执行查询操作
		Teacher t=session.get(Teacher.class, 3);
		System.out.println("原始缓存内容如下：\n"+t);
		t.setSex("male"); 	//缓存发生改变
		session.flush();	
	}
	@After
	public void selectTestAfter(){
		//提交事务方式1
		transacation.commit();
		//关闭session，在关闭session之前会检测事务是否已开启，若有开启则将提交事务
	//	session.close();	//提交事务方式2
		//关闭工厂类：在web应用中不需要关闭工厂类
	//	factory.close();
	}
}
