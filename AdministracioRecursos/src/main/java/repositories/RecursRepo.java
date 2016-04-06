package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Recurs;
import util.HibernateUtil;

public class RecursRepo {

	public static Recurs getByID(int id) {
		Recurs recurs = new Recurs();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = = :idVal");
			query.setLong("idVal", id);
			recurs = (Recurs) query.list().get(0);
			Hibernate.initialize(recurs.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return recurs;
	}

	public static List<Recurs> getAll() {
		List<Recurs> mList = new ArrayList<Recurs>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs");
			mList =  query.list();

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

	public static Recurs update(int id, String newName) {
		Recurs c = new Recurs();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = " + id);
			((Recurs) query.list().get(0)).setNom(newName);
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
		return c;

	}

	public static void delete(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = " + id);
			session.delete(((Recurs) query.list().get(0)));
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
