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
 * 单向多对一，只能从多段获取自己的班级信息，但是不能从1端（即班级）获取所有的学生信息
 */
public class GetTest {
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
		Stu_Class stuClass=session.get(Stu_Class.class, 1);
		Student s=session.get(Student.class, 1);
		System.out.println(stuClass);
		System.out.println(s);
		transaction.commit();
	}
}
