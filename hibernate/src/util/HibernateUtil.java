package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 * 由于创建配置文件对象以及SessionFactory类的对象只需要在应用中执行一次，所以将他们放在静态代码块中
 * 
 */
public class HibernateUtil {
	private static Configuration config=null;
	private static SessionFactory factory=null;
	static{
		config=new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
