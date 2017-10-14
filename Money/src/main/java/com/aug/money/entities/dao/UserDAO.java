/**
 * 
 */
package com.aug.money.entities.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.aug.money.entities.User;
import com.aug.money.util.HibernateUtil;

/**
 * @author AUG
 *
 */
public class UserDAO {
	
	private static final Logger _LOG = Logger.getLogger(UserDAO.class);

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Session session = HibernateUtil.getSession();
		List<User> result = new ArrayList<User>();
		
		try {
			Criteria criteria = session.createCriteria(User.class);
			result = criteria.list();
		} catch (Exception e) {
			_LOG.error("#getAll() - Exception occurs:", e);
		} finally {
			HibernateUtil.closeSession();
		}
		
		return result;
	}
	
}
