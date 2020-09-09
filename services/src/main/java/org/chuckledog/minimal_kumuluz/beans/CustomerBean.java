package org.chuckledog.minimal_kumuluz.beans;

import org.chuckledog.minimal_kumuluz.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class CustomerBean {

    @PersistenceContext(name = "minimal-jpa")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(CustomerBean.class.getName());

    public List<Customer> getAll(){
        return em.createNamedQuery("Customer.getAll").getResultList();
    }

    public Customer getById(int id){
        return em.find(Customer.class, id);
    }

    @Transactional
    public Customer create(String firstName, String lastName, String email){
        Customer customer = new Customer(firstName, lastName, email);

        em.persist(customer);

        return customer;
    }

    @Transactional
    public void delete(int id){
        Customer customer = em.find(Customer.class, id);

        if (customer != null){
            em.remove(customer);
        }
    }

}
