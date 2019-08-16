package oneToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import oneToOne2.User2;

public class SelectUserExt2FromUser2Test {
	Configuration config=null;
	SessionFactory factory=null;
	Session session=null;
	Transaction transaction=null;
	@Before
	public void select2Before(){
		config=new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
		session=factory.openSession();
		transaction=session.beginTransaction();
	}
	@Test
	public void select2Table(){
		/*双向查询：即可以从ext对象中读取User表中的相关信息；
		 * 也可以在User类的对象中读取UserExt表中的内容
		 * */
		User2 user=session.get(User2.class, 1);
		System.out.println(user.getExt());
		transaction.commit();
	}
}
