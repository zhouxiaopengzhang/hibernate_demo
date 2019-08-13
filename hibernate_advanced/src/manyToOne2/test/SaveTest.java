package manyToOne2.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import manyToOne2.Student2;
import manyToOne2.Teacher2;
/*
 * 该类主要用于说明在保存2个表大的记录，且这两张表的关系是1:n
 * 通常先保存关系“1”这边的记录，之后在保存“n”这边的记录
 * 为什么需要这样做：这样hibernate执行的SQL语句少
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
	/*该方法属于单向映射，因为仅仅在Student2的对象中添加了teacher，
	 * 但是并没有在Teacher2的对象中添加Student2的集
	 * 合（即没有使用setStudentSet()方法）
	 * */
	@Test
	public void create2Table(){
		Teacher2 t2=new Teacher2();
		t2.setTname("李老师");
		Student2 s=new Student2();
		s.setSname("小明");
		s.setTeacher2(t2);
		Student2 s2=new Student2();
		s2.setSname("小红");
		s2.setTeacher2(t2);
		/*
		 * 先保存“1”端的记录，再保存“n”端的记录
		 */
		session.save(t2);
		session.save(s);
		session.save(s2);
		transaction.commit();
		/*
		 * 控制台会打印3条insert语句，如果教
		 * 师t2在两个学生之后保存则会打印3条insert语
		 * 句以及2条update语句
		 */
	}
	
}
