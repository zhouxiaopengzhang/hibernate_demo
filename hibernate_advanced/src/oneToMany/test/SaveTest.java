package oneToMany.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import oneToMany.Stu_Class3;
import oneToMany.Student3;

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
		Stu_Class3 stuClass3=new Stu_Class3();
		stuClass3.setName("一班");
		Student3 s=new Student3();
		s.setName("张三");
		s.setAge(15);
		s.setSex("男");
		HashSet<Student3> hashSet=new HashSet<Student3>();
		hashSet.add(s);
		stuClass3.setStudent3s(hashSet);
		session.save(stuClass3);
		session.save(s);
		transaction.commit();
	}
}
