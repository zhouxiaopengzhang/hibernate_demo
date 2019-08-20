package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import manyToOne2.Student2;
import sessionfactory.HibernateSessionFactory;

public class PageQuery {
	/*分页查询*/
	@Test
	public void aliasQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		tran.begin();
		String query="from Student2";	
		Query q=session.createQuery(query);
		/*分页查询必须设置的2个参数，开始分页的地方以及分页的大小*/
		q.setFirstResult(1);	//设置从第n个记录开始分页
		q.setMaxResults(2);	//设置分页的大小
		List<Student2> list=q.list();
		System.out.println(list.isEmpty());
		for(Student2 s:list){
			System.out.println(s.getName());
		}
		tran.commit();
	}
}
