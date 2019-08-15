package manyToMany2.test;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import manyToMany2.Course4;
import manyToMany2.Student4;

/*多表查询*/
public class SelectTest {
	@Test
	public void selectTest(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		//这个HQL语句查询的结果是每条记录中包含两个对象
		String hql="from Course4 c inner join c.students" ;
		Query q=session.createQuery(hql);
		List<Object[]> list=q.list();
		for(Object[] o:list){
			Course4 c=(Course4) o[0];
			Student4 s=(Student4) o[1];
			System.out.println("["+c+s+"]");
		}
		transaction.commit();
	}
}
