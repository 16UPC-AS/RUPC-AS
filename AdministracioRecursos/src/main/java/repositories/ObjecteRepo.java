package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Objecte;
import util.HibernateUtil;

public class ObjecteRepo {

	public static Objecte getByID(int id) {
		Objecte objecte = new Objecte();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Objecte where id = :id");
			query.setLong("id", id);
			objecte = (Objecte) query.list().get(0);
			Hibernate.initialize(objecte.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objecte;
	}

	public static Objecte getByPK(Object arr[]) {
		Objecte objecte = new Objecte();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Objecte where nom = :nom");
			query.setString("nom", (String) arr[0]);
			objecte = (Objecte) query.list().get(0);
			Hibernate.initialize(objecte.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objecte;
	}

	public static List<Objecte> getAll() {
		List<Objecte> mList = new ArrayList<Objecte>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Objecte");
			mList = query.list();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return mList;

	}

	public static Objecte update(int id, String newName) {
		Objecte objecte = new Objecte();
		return objecte;
	}

	public static void delete(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Objecte where id = :id");
			query.setLong("id", id);
			session.delete(((Objecte) query.list().get(0)));
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public static void saveOrUpdate(Object o) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(o);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
