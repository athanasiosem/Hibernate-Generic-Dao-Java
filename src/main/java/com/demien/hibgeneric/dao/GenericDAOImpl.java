package com.demien.hibgeneric.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImpl<T> implements IGenericDAO<T> {
	private SessionFactory sessionFactory;

	public GenericDAOImpl(Class<T> cl, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		if (sessionFactory == null)
			throw new RuntimeException("Session factory is null!!!");
	}

	@Override
	public T get(Class<T> cl, Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T element = (T) session.get(cl, id);
		session.getTransaction().commit();
		return element;
	}

	@Override
	public T save(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		return object;
	}

	@Override
	public void update(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String hsql, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hsql);
		if (params != null) {
			for (String i : params.keySet()) {
				query.setParameter(i, params.get(i));
			}
		}

		List<T> result = null;
		if ((hsql.toUpperCase().indexOf("DELETE") == -1)
				&& (hsql.toUpperCase().indexOf("UPDATE") == -1)
				&& (hsql.toUpperCase().indexOf("INSERT") == -1)) {
			result = query.list();
		} else {
		}
		session.getTransaction().commit();

		return result;
	}

}
