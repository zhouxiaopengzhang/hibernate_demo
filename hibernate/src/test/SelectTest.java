package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import model.Teacher;
/*
 * hibernate中session对象从数据库中获取数据有两种方式：
 * 1.使用session.get()
 * 2.使用session.load()
 * 二者区别：当没有匹配到数据的时候get方法会返回null，而load会抛出异常
 */
public class SelectTest {
	@Test
	public void  selectTest(){
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
		 * get(Class<T> entity,Serialization id)方法和load()方法有2个参数：
		 * 第一个参数：代表查询返回的实体类的类型
		 * 第二个参数：代表查询的某一行的id
		 */
		Teacher t=session.get(Teacher.class, 3);
		//提交事务
		transacation.commit();
		//关闭session
		session.close();
		//关闭工厂类：在web应用中不需要关闭工厂类
		factory.close();
		System.out.println(t);
	}
}
