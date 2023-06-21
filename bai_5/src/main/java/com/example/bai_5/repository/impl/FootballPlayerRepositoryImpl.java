package com.example.bai_5.repository.impl;

import com.example.bai_5.model.FootballPlayer;
import com.example.bai_5.repository.ConnectionUtil;
import com.example.bai_5.repository.IFootballPlayerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class FootballPlayerRepositoryImpl implements IFootballPlayerRepository {

    @Override
    public List<FootballPlayer> findAll() {
        List<FootballPlayer> footballPlayers = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        footballPlayers = session.createQuery("from FootballPlayer").getResultList();
        session.close();
        return footballPlayers;
    }

    @Override
    public FootballPlayer findById(int id) {
        Session session = null;
        FootballPlayer footballPlayer;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            footballPlayer = (FootballPlayer) session.createQuery("FROM FootballPlayer where id = :id").setParameter("id", id).getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return footballPlayer;
    }

    @Override
    public Boolean delete(int id) {
        Transaction transaction = null;
        Session session = null;
        FootballPlayer footballPlayer = findById(id);
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(footballPlayer);
            transaction.commit();
        } catch (NoResultException noResultException) {
            return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public void create(FootballPlayer footballPlayer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(footballPlayer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Boolean edit(FootballPlayer footballPlayer) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(footballPlayer);
            transaction.commit();
        } catch (NoResultException noResultException) {
            return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }
}

