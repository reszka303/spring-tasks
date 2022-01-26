package pl.javastart.datadao.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.datadao.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

//    Operacje modyfikujące stan bazy danych, czyli insert, update i delete,
//    muszą być wykonywane w aktywnej transakcji.
//    Do tego celu najczęściej wykorzystuje się adnotację @Transactional
    @Transactional
    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    public Customer read(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public Customer update(Customer customer) {
        return entityManager.merge(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        Customer attachedCustomer = read(customer.getId());
        entityManager.remove(attachedCustomer);
    }

}
