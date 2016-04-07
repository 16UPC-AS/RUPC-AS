package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Recurs;
import entities.Sala;
import util.HibernateUtil;

public class SalaRepo extends BasicRepo {

	public static Sala getByID(Long id) {
		Sala sala = new Sala();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Sala where id = :id");
			query.setLong("id", id);
			sala = (Sala) query.list().get(0);
			Hibernate.initialize(sala.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sala;
	}

	public static List<Recurs> getAll() {
		List<Recurs> mList = new ArrayList<Recurs>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Sala");
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

}
