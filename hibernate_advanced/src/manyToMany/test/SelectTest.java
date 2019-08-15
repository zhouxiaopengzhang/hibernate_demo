package manyToMany.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import manyToMany.Course5;
import manyToMany.Student5;

public class SelectTest {
	@Test
	public void selectTest(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Course5 c=session.get(Course5.class, 1);
		Set<Student5> s=c.getStudents();
		Iterator<Student5> iterator=s.iterator();
		System.out.println("选修了java课程的学生");
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		transaction.commit();
	}
}
