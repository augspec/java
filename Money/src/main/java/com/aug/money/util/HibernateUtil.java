package com.aug.money.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	static {
		try { 
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		Session _session = session.get();
		if (_session == null || !_session.isOpen()) {
			_session = sessionFactory.openSession();
			session.set(_session);
		}
		return _session;
	}
	
	public static boolean commit(Transaction transaction) {
		try {
			if (transaction != null && !transaction.wasCommitted()) {
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean rollback(Transaction transaction) {
		try {
			if (transaction != null && !transaction.wasCommitted()) {
				transaction.rollback();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void closeSession() {
		Session _session = session.get();
		if (_session != null) {
			_session.close();
		}
		session.set(null);
	}
}