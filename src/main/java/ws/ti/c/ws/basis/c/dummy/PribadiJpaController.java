/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.ti.c.ws.basis.c.dummy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ws.ti.c.ws.basis.c.dummy.exceptions.NonexistentEntityException;
import ws.ti.c.ws.basis.c.dummy.exceptions.PreexistingEntityException;

/**
 *
 * @author Tegar
 */
public class PribadiJpaController implements Serializable {

//    public PribadiJpaController(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ws.ti.c_ws.basis.c_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PribadiJpaController() {
    }
    
    

    public void create(Pribadi pribadi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pribadi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPribadi(pribadi.getId()) != null) {
                throw new PreexistingEntityException("Pribadi " + pribadi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pribadi pribadi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pribadi = em.merge(pribadi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pribadi.getId();
                if (findPribadi(id) == null) {
                    throw new NonexistentEntityException("The pribadi with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pribadi pribadi;
            try {
                pribadi = em.getReference(Pribadi.class, id);
                pribadi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pribadi with id " + id + " no longer exists.", enfe);
            }
            em.remove(pribadi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pribadi> findPribadiEntities() {
        return findPribadiEntities(true, -1, -1);
    }

    public List<Pribadi> findPribadiEntities(int maxResults, int firstResult) {
        return findPribadiEntities(false, maxResults, firstResult);
    }

    private List<Pribadi> findPribadiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pribadi.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pribadi findPribadi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pribadi.class, id);
        } finally {
            em.close();
        }
    }

    public int getPribadiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pribadi> rt = cq.from(Pribadi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
