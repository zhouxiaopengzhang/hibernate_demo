package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import manyToOne2.Student2;
import sessionfactory.HibernateSessionFactory;

public class ParameterQuery {
	/*别名查询*/
	@Test
	public void parameterQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		tran.begin();
		/*由于当前项目使用的hibernate版本是5.1；在hibernate5.2之后才出现JPA-style*/
		//把学生姓名当做参数进行查询
		String query="from Student2 where name = :pname";	//方式，这是5.2版本之前的方式
		Query q=session.createQuery(query);
		q.setParameter("pname", "张三");
		List<Student2> list=q.list();
		System.out.println(list.isEmpty());
		for(Student2 s:list){
			System.out.println(s.getName());
		}
		tran.commit();
	}
}
