package level2cache.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import level2cache.Car;
/*测试单表二级缓存*/
public class Level2CacheTest {
	Configuration config=null;
	SessionFactory factory=null;
	Session session=null;
	Transaction transaction=null;
	@Before
	public void testBefore(){
		config=new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
		session=factory.openSession();
		transaction=session.beginTransaction();
	}
	/*只重复查询了表中的一条记录*/
	@Test
	public void saveTest(){
		Car car=session.get(Car.class, 1);
		System.out.println(car);
		transaction.commit();
		session.close();
		session=factory.openSession();
		transaction=session.beginTransaction();
		//如果SQL只执行了一次，那么说明二级缓存配置成功
		/*
		 * 数据检索路径：先去session中检索，如果session中没有，则去二级缓
		 * 存（即SessionFactory）中检索，若还没有则去数据库中检索
		*/
		Car car2=session.get(Car.class, 1);
		System.out.println(car2);
		transaction.commit();
	}
}
