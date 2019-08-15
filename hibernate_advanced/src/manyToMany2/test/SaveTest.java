package manyToMany2.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import manyToMany2.Course4;
import manyToMany2.Student4;

public class SaveTest {
	@Test
	public void save(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Student4 s=new Student4();
		s.setName("张三");
		Student4 s2=new Student4();
		s2.setName("李四");
		Student4 s3=new Student4();
		s3.setName("王五");
		Course4 c=new Course4();
		c.setName("java课程");
		/*添加集合属性*/
		HashSet<Student4> c_set=new HashSet<Student4>();
		c_set.add(s);
		c_set.add(s2);
		c_set.add(s3);

		/*向中间表student_course中添加记录从而关联学生表与课程表*/
		c.setStudents(c_set);
		
		session.save(c);
		session.save(s);
		session.save(s2);
		session.save(s3);
		transaction.commit();
	}
}
