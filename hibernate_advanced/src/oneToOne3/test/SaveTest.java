package oneToOne3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import oneToOne3.User3;
import oneToOne3.UserExt3;
public class SaveTest {
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
		User3 user=new User3();
		user.setName("李四");
		UserExt3 ext=new UserExt3();
		ext.setIdCardNum("123000001");
		ext.setSex(1);
		ext.setUser(user);
		//先保存主表，再保存包含外键的表
		session.save(user);
		session.save(ext);
		transaction.commit();
	}
}
