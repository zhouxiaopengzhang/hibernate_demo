package level2cache.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import level2cache.Car;

/*本表用于时间戳缓存区域的验证*/
public class TimeStampQueryTest {
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
	/*时间戳缓存区域概念：当对某张表的一个记录执行了一次查询之后又更新了该记
	 * 录，紧接着又执行了对该记录进行查询，那么查询的这条记录是更新之前的还是之后的
	 * 数据呢？根据验证结果说明查询的是更新之后的数据。*/
	@SuppressWarnings("unchecked")
	@Test
	public void timeStampQueryTest(){
		String hql="from Car where id = ?";
		Query query=session.createQuery(hql);
		query.setParameter(0, 1);
		query.setCacheable(true);
		//第一次获取数据并放到缓存中
		List<Car> list=query.list();
		System.out.println(list);
		//第二次获取并修改数据
		Car c=session.get(Car.class, 1);
		c.setModel("E级");
		//第三次获取数据，证实获取的数据时更新之后的
		List<Car> list2=query.list();
		System.out.println(list2);
		transaction.commit();
	}
}
