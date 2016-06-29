package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

@Repository

public class OrderRepository {
    @PersistenceContext
    private EntityManager em;

    public Order getById(Long id){
        return em.find(Order.class, id);
    }

    public List<Order> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> rootEntry = cq.from(Order.class);
        cq = cq.select(rootEntry);
        TypedQuery<Order> query = em.createQuery(cq);
        return query.getResultList();
    }
    @Transactional
    public Order save(Order o){
        em.persist(o);
        em.flush();
        return o;
    }

    @Transactional
    public void delete(Order o){
        Order or = getById(o.getOrderId());
        em.remove(or);
    }

    @Transactional
    public Order update(Order o){
        Order or = getById(o.getOrderId());
        or.setApproved(o.getApproved());
        return or;
    }
}
