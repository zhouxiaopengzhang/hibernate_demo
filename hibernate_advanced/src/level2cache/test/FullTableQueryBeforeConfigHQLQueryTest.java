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
/*在配置HQL查询缓存的情况下检索整张表的内容*/
public class FullTableQueryBeforeConfigHQLQueryTest {
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
	/*重复查询了一张表的所有记录，结果同样的SQL语句执行一次
	 * 说明配置的HQL查询缓存生效了
	 * */
	@SuppressWarnings("unchecked")
	@Test
	public void fullTableQueryTest(){
		String hql="from Car";
		Query query=session.createQuery(hql);
		query.setCacheable(true);	//该语句不能少，否则结果同样的SQL语句还是执行2次
		List<Car> list=query.list();
		System.out.println(list);
		
		Query query2=session.createQuery(hql);
		query2.setCacheable(true);  //该语句不能少，否则结果同样的SQL语句还是执行2次
		List<Car> list2=query2.list();
		System.out.println(list2);
		
	}
}
