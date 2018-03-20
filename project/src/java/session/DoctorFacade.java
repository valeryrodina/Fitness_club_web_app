package session;

import entities.Doctor;
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
public class DoctorFacade extends AbstractFacade<Doctor> {

    @PersistenceContext(unitName = "projectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorFacade() {
        super(Doctor.class);
    }
    
    public Doctor getDoctorByPersonId(Object personId){
        try {  
            Query q = em.createNamedQuery("Doctor.findByPersonId", Doctor.class);
            q.setParameter("personId", personId);
            return (Doctor)q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
}
