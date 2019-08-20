package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import manyToOne2.Student2;
import sessionfactory.HibernateSessionFactory;

public class FullTableQuery {
	/*全表查询*/
	@Test
	public void fullTableQuery(){
		Session session=HibernateSessionFactory.getSession();
		String query="from Student2";
		Query q=session.createQuery(query);
		List<Student2> list=q.list();
		for(Student2 s:list){
			System.out.println(s.getName());
		}
	}
}
