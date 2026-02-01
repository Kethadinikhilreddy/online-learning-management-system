package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.dto.StudentDetails;
import org.jsp.dto.UserDetails;
import util.JPAUtil;

public class UserDao {

    
    public UserDetails saveUser(UserDetails user) {
    	
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(user);
            et.commit();
            return user;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    
    
    public UserDetails findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        UserDetails user = em.find(UserDetails.class, id);
        em.close();
        return user;
    }
    
    public UserDetails findByEmail(String email) {
    		EntityManager em = JPAUtil.getEntityManager();
    		String select="SELECT u FROM UserDetails u WHERE u.email = :email";
    		try {
    			Query query = em.createQuery(select);
    			query.setParameter("email",email);
    			UserDetails result = (UserDetails)query.getSingleResult();
    			return result;
    		}
    		catch(Exception e) {
    			return null;
    		}
    		finally {
    			em.close();
    		}
    }
    
    
    public UserDetails updateUser(UserDetails user) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            UserDetails updatedUser = em.merge(user);
            et.commit();
            return updatedUser;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    public boolean deleteUser(int uid) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            UserDetails user = em.find(UserDetails.class, uid);
            if (user != null) {
                et.begin();
                em.remove(user);
                et.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
