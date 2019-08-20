package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import sessionfactory.HibernateSessionFactory;

public class AggregateQuery {
	/*聚合查询：使用聚合函数*/
	@Test
	public void aliasQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		tran.begin();
		//使用sum()聚合函数
		String query="select sum(age) from Student2";
		
		Query q=session.createQuery(query);
		List<Long> list=q.list();
		System.out.println(list.isEmpty());
		for(Long i:list){
			System.out.println(i);
		}
		tran.commit();
	}
}
