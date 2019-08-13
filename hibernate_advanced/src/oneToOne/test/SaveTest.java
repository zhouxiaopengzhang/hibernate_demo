package oneToOne.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import oneToOne.User;
import oneToOne.UserExt;
	/*单向一对一保存*/
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
	public void create2Table(){
		User user=new User();
		user.setUserName("张三");
		UserExt ext=new UserExt();
		ext.setIdCardNum("12233333");
		ext.setSex(1);
		ext.setUser(user);
		session.save(user);
		session.save(ext);
		transaction.commit();
	}
}
