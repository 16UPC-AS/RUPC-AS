package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Objecte;
import entities.Sala;
import util.HibernateUtil;

public class ObjecteRepo extends BasicRepo {
//
//	public static Objecte getByID(Long id) {
//		Objecte objecte ;//= new Objecte();
//		Session session = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//
//			Query query = session.createQuery("from Objecte where id = :id");
//			query.setLong("id", id);
//			objecte = (Objecte) query.list().get(0);
//			Hibernate.initialize(objecte.getId());
//		} catch (Exception e) {
//			if (session != null) {
//				session.getTransaction().rollback();
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return objecte;
//	}
//
//	public static List<Objecte> getAll() {
//		List<Objecte> mList = new ArrayList<Objecte>();
//		Session session = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//
//			Query query = session.createQuery("from Objecte");
//			mList = query.list();
//
//		} catch (Exception e) {
//			if (session != null) {
//				session.getTransaction().rollback();
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return mList;
//	}
//
//	public List<Objecte> getBySala(Sala sala) {
//		List<Objecte> mList = new ArrayList<Objecte>();
//		Session session = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//
//			Query query = session.createQuery("from Objecte");
//			mList = query.list();
//			for (Objecte o : mList) {
//				if (o.getSala() == null || !o.getSala().getId().getId().equals(sala.getId().getId()))
//					mList.remove(o);
//			}
//
//		} catch (Exception e) {
//			if (session != null) {
//				session.getTransaction().rollback();
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return mList;
//	}

}
