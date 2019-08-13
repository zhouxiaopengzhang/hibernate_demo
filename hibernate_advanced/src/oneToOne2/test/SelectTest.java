package oneToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import oneToOne2.User2;
import oneToOne2.UserExt2;

public class SelectTest {
	/*双向查询*/
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
	@Test
	public void selectTest(){
		/*这是双向查询：即从ext对象中读取User表中的相关信息
		 * 如果还可以在User类的对象中读取UserExt表中的内容，那么就代表双向查询
		 * */
		UserExt2 ext=session.load(UserExt2.class, 2);
		
		User2 user=session.load(User2.class, 1);
		System.out.println(user.getExt());
		System.out.println(ext.getUser());
		transaction.commit();
	}
}
