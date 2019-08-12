package test;
/*该类用于测试session的一级缓存*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import model.Teacher;

public class SessionCacheTest {
	/*该测试方法用于证明Session存在缓存*/
	@Test
	public void sessioncacheTest(){
		//创建configuration
				Configuration conf=new Configuration();
				//读取配置文件
				conf.configure();
				//创建一个SessionFactory工厂类
				SessionFactory factory=conf.buildSessionFactory();
				//通过工厂开启Session对象
				Session session=factory.openSession();
				//开始事务
				Transaction transacation=session.beginTransaction();
				//通过session对象执行查询操作
				/*
				 * session存在缓存：
				 * 当数据被取出之后，在此从数据库取相同数据时，会先查询session对
				 * 象是否存在该对象的缓存
				 */
				Teacher t=session.get(Teacher.class, 3);
				System.out.println("第一次查询："+t);
				Teacher t2=session.get(Teacher.class, 3);
				System.out.println("第二次查询："+t2);
				//提交事务
				transacation.commit();
				//关闭session
				session.close();
				//关闭工厂类：在web应用中不需要关闭工厂类
				factory.close();
	}
	/*
	 * 该测试方法用于解释缓存的用途
	 * 
	 */
	@Test
	public void sessionCacheEffectTest(){
		Teacher teacher=new Teacher();
		teacher.setId(5);
		teacher.setLevel("高级");
		teacher.setName("张三");
		teacher.setSex("女");
		//创建configuration
		Configuration conf=new Configuration();
		//读取配置文件
		conf.configure();
		//创建一个SessionFactory工厂类
		SessionFactory factory=conf.buildSessionFactory();
		//通过工厂开启Session对象
		Session session=factory.openSession();
		//开始事务
		Transaction transacation=session.beginTransaction();
		//通过session对象执行更新操作
		teacher.setSalary(7000);	
		session.update(teacher);
		teacher.setSalary(8000);
		session.update(teacher);
		//提交事务
		transacation.commit();
		//关闭session
		session.close();
		//关闭工厂类：在web应用中不需要关闭工厂类
		factory.close();
	}
}
