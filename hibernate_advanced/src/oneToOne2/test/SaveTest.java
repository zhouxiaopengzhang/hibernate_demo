package oneToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import oneToOne2.User2;
import oneToOne2.UserExt2;

public class SaveTest {
	/*双向保存*/
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
	public void saveTest(){
		User2 user=new User2();
		user.setUserName("李四");
		UserExt2 ext=new UserExt2();
		ext.setIdCardNum("123000001");
		ext.setSex(1);
		ext.setUser(user);
		user.setExt(ext);
		//先保存主表，再保存包含外键的表
		session.save(user);
		session.save(ext);
		transaction.commit();
	}
}
