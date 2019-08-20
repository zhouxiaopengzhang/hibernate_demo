package manyToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import manyToOne2.Stu_Class2;
import manyToOne2.Student2;

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
	/*测试双向多对一的查询*/
	@Test
	public void saveTest(){
		Stu_Class2 stuClass2=session.get(Stu_Class2.class, 1);
		stuClass2.getStudent2s();
		System.out.println(stuClass2);
		Student2 s=session.get(Student2.class, 1);
		System.out.println(s);
		transaction.commit();
	}
}
