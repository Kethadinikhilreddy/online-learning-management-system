package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jsp.dto.BatchDetails;
import org.jsp.dto.StudentDetails;
import util.JPAUtil;

public class StudentDao {

    public StudentDetails saveStudent(StudentDetails student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(student); 
            et.commit();
            return student;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    public StudentDetails findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        String sleect="SELECT s FROM StudentDetails s WHERE s.email = :email";
        try {
            Query query = em.createQuery(sleect);
            query.setParameter("email", email);
            return (StudentDetails) query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } finally {
            em.close();
        }
    }
    
    public StudentDetails findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        StudentDetails student = em.find(StudentDetails.class, id);
        em.close();
        return student;
    }


    
    public StudentDetails updateStudent(StudentDetails student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            StudentDetails updatedStudent = em.merge(student);
            et.commit();
            return updatedStudent;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    public boolean deleteStudent(int sid) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            StudentDetails student = em.find(StudentDetails.class, sid);
            if (student != null) {
                et.begin();
                em.remove(student); 
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

    
    public boolean addStudentToBatch(StudentDetails student, BatchDetails batch) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            
            
            StudentDetails managedStudent = em.merge(student);
            BatchDetails managedBatch = em.merge(batch);
            
            
            managedStudent.getBatches().add(managedBatch);
            managedBatch.getStudents().add(managedStudent);
            
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    
    public boolean removeStudentFromBatch(StudentDetails student, BatchDetails batch) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            
            
            StudentDetails managedStudent = em.merge(student);
            BatchDetails managedBatch = em.merge(batch);
            
            
            managedStudent.getBatches().remove(managedBatch);
            managedBatch.getStudents().remove(managedStudent);
            
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    
    public List<StudentDetails> getAllStudents() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String select = "SELECT s FROM StudentDetails s";
            Query query = em.createQuery(select);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    
    public List<BatchDetails> getBatchesOfStudent(StudentDetails student) {
        StudentDetails s = findByEmail(student.getEmail());
        if (s != null) {
            return s.getBatches();
        }
        return null;
    }
    
    public StudentDetails findStudentWithBatches(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        StudentDetails student = em.createQuery(
            "SELECT s FROM StudentDetails s LEFT JOIN FETCH s.batches WHERE s.id = :id",
            StudentDetails.class
        ).setParameter("id", id)
         .getSingleResult();

        em.close();
        return student;
    }

}
