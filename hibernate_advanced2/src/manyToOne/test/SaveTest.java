package manyToOne.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import manyToOne.Stu_Class;
import manyToOne.Student;
/*
 * 该类测试为什么需要双向多对一
 */
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
		Stu_Class stuClass=new Stu_Class();
		stuClass.setCname("一班");
		Student s=new Student();
		s.setName("张三");
		s.setAge(15);
		s.setStuClass(stuClass);
		session.save(stuClass);
		session.save(s);
		transaction.commit();
	}
}
