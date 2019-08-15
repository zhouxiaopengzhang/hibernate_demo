package manyToMany.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import manyToMany.Course5;
import manyToMany.Student5;

public class SaveTest {
	@Test
	public void save(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Student5 s=new Student5();
		s.setName("张三");
		Student5 s2=new Student5();
		s2.setName("李四");
		Student5 s3=new Student5();
		s3.setName("王五");
		Course5 c=new Course5();
		c.setName("java课程");
		/*添加集合属性*/
		HashSet<Student5> c_set=new HashSet<Student5>();
		c_set.add(s);
		c_set.add(s2);
		c_set.add(s3);

		/*向中间表student5_course5中添加记录从而关联学生表与课程表*/
		c.setStudents(c_set);
		
		session.save(c);
		session.save(s);
		session.save(s2);
		session.save(s3);
		transaction.commit();
	}
}
