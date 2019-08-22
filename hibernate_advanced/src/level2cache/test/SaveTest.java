package level2cache.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import level2cache.Car;
public class SaveTest {
	@Test
	public void save(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Car car=new Car();
		car.setBrand("奔驰");
		car.setModel("c级");
		car.setPrice(400000);
		Car car2=new Car();
		car2.setBrand("宝马");
		car2.setModel("3系");
		car2.setPrice(350000);
		Car car3=new Car();
		car3.setBrand("奥迪");
		car3.setModel("A4");
		car3.setPrice(330000);
		session.save(car);
		session.save(car2);
		session.save(car3);
		
		transaction.commit();
	}
}
