package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.dto.BatchDetails;
import org.jsp.dto.StudentDetails;
import util.JPAUtil;

public class BatchDao {

    public BatchDetails saveBatch(BatchDetails batch) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(batch);
            et.commit();
            return batch;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    public BatchDetails findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        BatchDetails batch = em.find(BatchDetails.class, id);
        em.close();
        return batch;
    }

    
    public BatchDetails findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        String queryStr = "SELECT b FROM BatchDetails b WHERE b.name = :name";

        try {
            Query query = em.createQuery(queryStr);
            query.setParameter("name", name);
            return (BatchDetails) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    
    public BatchDetails updateBatch(BatchDetails batch) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            BatchDetails updatedBatch = em.merge(batch);
            et.commit();
            return updatedBatch;
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    public boolean deleteBatch(int bid) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            BatchDetails batch = em.find(BatchDetails.class, bid);
            if (batch == null) return false;

            // Remove batch from all students
            for (StudentDetails student : batch.getStudents()) {
                student.getBatches().remove(batch);
            }

            // Clear batch students list
            batch.getStudents().clear();

            em.remove(batch);
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


    
    public boolean addStudentToBatch(BatchDetails batch, StudentDetails student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            BatchDetails managedBatch = em.merge(batch);
            StudentDetails managedStudent = em.merge(student);

            managedBatch.getStudents().add(managedStudent);
            managedStudent.getBatches().add(managedBatch);

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

    
    public boolean removeStudentFromBatch(BatchDetails batch, StudentDetails student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            BatchDetails managedBatch = em.merge(batch);
            StudentDetails managedStudent = em.merge(student);

            managedBatch.getStudents().remove(managedStudent);
            managedStudent.getBatches().remove(managedBatch);

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

    
    public List<StudentDetails> getStudentsOfBatch(BatchDetails batch) {
        EntityManager em = JPAUtil.getEntityManager();

        BatchDetails b = em.createQuery(
            "SELECT b FROM BatchDetails b LEFT JOIN FETCH b.students WHERE b.id = :id",
            BatchDetails.class
        ).setParameter("id", batch.getBid())
         .getSingleResult();

        em.close();
        return b.getStudents();
    }

    
    public BatchDetails findBatchWithStudents(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        BatchDetails batch = em.createQuery(
            "SELECT b FROM BatchDetails b LEFT JOIN FETCH b.students WHERE b.id = :id",
            BatchDetails.class
        ).setParameter("id", id)
         .getSingleResult();

        em.close();
        return batch;
    }
    
    
    public List<BatchDetails> getAllBatches() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String select = "SELECT b FROM BatchDetails b";
            Query query = em.createQuery(select);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    
    public List<BatchDetails> getAllBatchesWithStudents() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT DISTINCT b FROM BatchDetails b LEFT JOIN FETCH b.students",
                BatchDetails.class
            ).getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<BatchDetails> getAvailableBatchesForStudent(int studentId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<BatchDetails> batches = em.createQuery(
            "SELECT b FROM BatchDetails b WHERE b NOT IN (" +
            "SELECT b2 FROM StudentDetails s JOIN s.batches b2 WHERE s.id = :sid)",
            BatchDetails.class
        )
        .setParameter("sid", studentId)
        .getResultList();

        em.close();
        return batches;
    }


}
