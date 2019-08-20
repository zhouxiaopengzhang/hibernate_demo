package manyToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


import manyToOne2.Stu_Class2;
import manyToOne2.Student2;

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
		Stu_Class2 stuClass2=new Stu_Class2();
		stuClass2.setName("一班");
		Student2 s=new Student2();
		s.setName("张三");
		s.setSex("男");
		s.setAge(16);
		s.setStuClass(stuClass2);
		session.save(s);
		session.save(stuClass2);
		transaction.commit();
	}
}
