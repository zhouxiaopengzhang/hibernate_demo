package hql;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import manyToOne2.Stu_Class2;
import manyToOne2.Student2;
import sessionfactory.HibernateSessionFactory;

public class InnerJoinQuery {
	@Test
	public void innerJoinQuery(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		tran.begin();
		//使用sum()聚合函数
		String query="from Stu_Class2 c inner join c.student2s";
		
		Query q=session.createQuery(query);
		List<Object[]> list=q.list();
		System.out.println(list.isEmpty());
		for(Object[] value:list){
			Stu_Class2 stuClass=(Stu_Class2) value[0];
			Student2 stu=(Student2) value[1];
			System.out.println("["+stuClass+"]["+stu+"]");
		}
		tran.commit();
	}
}
