package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import model.Teacher;
public class DeleteTest {
	
	@Test
	public void  deleteTest(){
		
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
		//通过session对象执行数据库的操作
		Teacher t=new Teacher();
		t.setId(1);
		session.delete(t);
		//提交事务
		transacation.commit();
		//关闭session
		session.close();
		//关闭工厂类：在web应用中不需要关闭工厂类
		factory.close();
	}
}
