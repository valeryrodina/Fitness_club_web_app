package session;

import entities.Manager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author valeryrodina
 */
@Stateless
public class ManagerFacade extends AbstractFacade<Manager> {

    @PersistenceContext(unitName = "projectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManagerFacade() {
        super(Manager.class);
    }
    
    public Manager getManagerByPersonId(Object personId){
        try{
            Query q = em.createNamedQuery("Manager.findByPersonId", Manager.class);
            q.setParameter("personId", personId);
            return (Manager)q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
        
    }
}
