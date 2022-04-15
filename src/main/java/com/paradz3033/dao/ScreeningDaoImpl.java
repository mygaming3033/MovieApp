package com.paradz3033.dao;

import com.paradz3033.HibernateUtil;
import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ScreeningDaoImpl implements ScreeningDao{
    @Override
    public List<Screening> getScreenings() {
        List <Screening> screenings = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            screenings = session.createQuery("from Screening", Screening.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenings;
    }

    @Override
    public List<Screening> getScreenings(long movieId) {
        List <Screening> screenings = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            screenings = session.createQuery("from Screening s WHERE s.movieId = "+movieId, Screening.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenings;
    }

    @Override
    public boolean addScreening(Screening screening) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(screening);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteScreening(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction txn = session.beginTransaction();
            String hql = "DELETE FROM Screening WHERE id = "+id;
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            txn.commit();
            return result>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
