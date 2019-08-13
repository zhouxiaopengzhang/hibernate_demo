package manyToOne2.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import manyToOne2.Student2;
import manyToOne2.Teacher2;
/*双向保存*/
public class TwoWaySaveTest {
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
	/*该方法属于双向映射，因为不仅在Student2的对象中添加了teacher，
	 * 还在Teacher2的对象中添加Student2的集
	 * 合（即使用setStudentSet()方法）
	 * */
	@Test
	public void create2Table(){
		Teacher2 t2=new Teacher2();
		t2.setTname("李老师2");
		Student2 s=new Student2();
		s.setSname("小明2");
		s.setTeacher2(t2);
		Student2 s2=new Student2();
		s2.setSname("小红2");
		/*把教师对象添加到学生中，这样构成了单向1:n*/
		s2.setTeacher2(t2);
		/*把学生添加到老师对象中，这样子就构成了双向1:n，双端都会维护这个对
		 * 象，会产生3条insert语句以及2条update语句
		 */
		Set<Student2> set=new HashSet<Student2>();
		set.add(s);
		set.add(s2);
		t2.setStudentSet(set);
		/*
		 * 先保存“1”端的记录，再保存“n”端的记录
		 */
		session.save(t2);
		session.save(s);
		session.save(s2);
		transaction.commit();
		/*
		 * 控制台会打印3条insert语句以及2条update语句
		 */
		
	}
}
