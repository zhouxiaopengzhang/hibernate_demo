package manyToOne2.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import manyToOne2.Student2;
import manyToOne2.Teacher2;
/*
 * 该类测试为什么需要双向多对一
 */
public class TestDemo {
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
		//在单向多对一里面就已经完成了基本的操作功能，为什么需要双向多对一？
		//学生只有一个老师，老师可以交多个学生
		Student2 s=session.get(Student2.class, 1);	
		System.out.println(s.getTeacher2());
		//单向一对多使用场景：已知student，想要知道当前学生的老师是谁
		//双向一对多使用场景：已知teacher，想要知道当前老师教了多少学生
		
		Teacher2 t2=session.get(Teacher2.class, 1);
		Set<Student2> set=t2.getStudentSet();
		Iterator<Student2> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		transaction.commit();
	}
	
}
