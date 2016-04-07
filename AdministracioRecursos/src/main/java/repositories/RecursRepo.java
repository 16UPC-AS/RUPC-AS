package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Recurs;
import util.HibernateUtil;

public class RecursRepo extends BasicRepo {

	public static Recurs getByID(Long id) {
		Recurs recurs = new Recurs();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = :id");
			query.setLong("id", id);
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

	public static Recurs getByPK(Object arr[]) {
		Recurs recurs = new Recurs();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where nom = :nom");
			query.setString("nom", (String) arr[0]);
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

	public static Recurs update(Long id, String newName) {
		Recurs recurs = new Recurs();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = :id");
			query.setLong("id", id);
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
		return recurs;

	}

	public static void delete(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Recurs where id = :id");
			query.setLong("id", id);
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

}
