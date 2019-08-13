package manyToOne.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import manyToOne.Student;
import manyToOne.Teacher;

/*
 * 在一个事务中保存1条学生记录到学生表以及一条教师记录到教师表
 */
public class SaveTest {
	@Test
	public void save(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		/*由于设置teacher表的主键自动增长，因此不需要设置tid属性*/
		Teacher t=new Teacher();
		t.setTname("张翠山");
		session.save(t);
		Student st1=new Student();
		st1.setSname("赵六");
		st1.setTeacher(t);
		session.save(st1);
		Student st2=new Student();
		st2.setSname("胜七");
		st2.setTeacher(t);
		session.save(st2);
		transaction.commit();
	}
}
