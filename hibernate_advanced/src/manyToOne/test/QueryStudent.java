package manyToOne.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import manyToOne.Student;

public class QueryStudent {
	@Test
	public void seletQuery(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		//获取学生表student中的主键sid为1的记录
		Student s=session.get(Student.class, 1);
		transaction.commit();
		/*
		 * 下列打印语句并没有使用到teacher表中的记录，
		 * 因此hibernate不会查询teacher表的记录
		 */
		System.out.println(s.getSname());
	}
}
