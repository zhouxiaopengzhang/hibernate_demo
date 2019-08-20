package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import manyToOne2.Student2;
import sessionfactory.HibernateSessionFactory;

public class ProjectionQuery {
	/*投影查询*/
	@Test
	public void aliasQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		tran.begin();
		/*投影HQL语句有2种*/
		//第一种：返回的是仅仅是Student2的name属性的值的集合
		String query="select name from Student2";
		//第二种：返回的是Student的集合，前提是有相应的构造方法
		//String query="select new Student2(name) from Student2";
		Query q=session.createQuery(query);
		List<String> list=q.list();
		System.out.println(list.isEmpty());
		for(String s:list){
			System.out.println(s);
		}
		tran.commit();
	}
}
