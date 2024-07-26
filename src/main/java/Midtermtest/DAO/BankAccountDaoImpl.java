package Midtermtest.DAO;

import Midtermtest.DTO.BankAccount;
import Midtermtest.UTIL.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;


import java.util.List;

public class BankAccountDaoImpl implements BankAccountDao {

    @Override
    public void create(BankAccount account) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(account);
        transaction.commit();
        em.close();
    }

    @Override
    public BankAccount read(int actNumber) {
        EntityManager em = HibernateUtil.getEntityManager();
        BankAccount account = em.find(BankAccount.class, actNumber);
        em.close();
        return account;
    }

    @Override
    public void update(BankAccount account) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(account);
        transaction.commit();
        em.close();
    }

    @Override
    public void delete(int actNumber) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        BankAccount account = em.find(BankAccount.class, actNumber);
        if (account != null) {
            em.remove(account);
            transaction.commit();
        }
        em.close();
    }

    @Override
    public List<BankAccount> findByCustomerName(String customerName) {
        EntityManager em = HibernateUtil.getEntityManager();
        Query query = em.createQuery("FROM BankAccount WHERE customerName = :customerName", BankAccount.class);
        query.setParameter("customerName", customerName);
        List<BankAccount> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<BankAccount> findByBranchCode(int branchCode) {
        EntityManager em = HibernateUtil.getEntityManager();
        Query query = em.createQuery("FROM BankAccount WHERE branchCode = :branchCode", BankAccount.class);
        query.setParameter("branchCode", branchCode);
        List<BankAccount> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Object[]> findAllGroupedByCity() {
        EntityManager em = HibernateUtil.getEntityManager();
        Query query = em.createQuery("SELECT actNumber, customerName, city FROM BankAccount GROUP BY city", Object[].class);
        List<Object[]> result = query.getResultList();
        em.close();
        return result;
    }
}

