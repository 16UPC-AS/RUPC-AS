package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Ordinador;
import entities.Recurs;
import util.HibernateUtil;

public class OrdinadorRepo extends BasicRepo {

	public static Ordinador getByID(Long id) {
		Ordinador ordinador = new Ordinador();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Ordinador where id = :id");
			query.setLong("id", id);
			ordinador = (Ordinador) query.list().get(0);
			Hibernate.initialize(ordinador.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ordinador;
	}

	public static List<Recurs> getAll() {
		List<Recurs> mList = new ArrayList<Recurs>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Ordinador");
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
