package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Pizza;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PizzaRepository {
    @PersistenceContext
    private EntityManager em;

    public Pizza getById(Long id){
        return em.find(Pizza.class, id);
    }

    public List<Pizza> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pizza> cq = cb.createQuery(Pizza.class);
        Root<Pizza> rootEntry = cq.from(Pizza.class);
        cq = cq.select(rootEntry);
        TypedQuery<Pizza> query = em.createQuery(cq);
        return query.getResultList();
    }
    @Transactional
    public Pizza save(Pizza p){

        em.persist(p);
        em.flush();
        return p;
    }
    @Transactional
    public void delete(Long id){
        Pizza pz = getById(id);
        em.remove(pz);
    }

    @Transactional
    public Pizza update(Pizza p){
        Pizza pz = getById(p.getId());
        pz.setType(p.getType());
        return pz;
    }
}
