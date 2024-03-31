/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rakotomanga.tpcustomerrakotomanga.service;


import com.rakotomanga.tpcustomerrakotomanga.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Façade pour gérer les Customers.
 * Elle contient des méthodes pour récupérer tous les customers,
 * mettre à jour un customer existant et insérer un nouveau customer.
 * @author Hasina
 */

@RequestScoped  
public class CustomerManager {  

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * GetAllCustomer permet d'avoir la list des customer
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    /**
     * update permet de modifier un customer
     * @param customer Le customer à mettre à jour
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    /**
     * persist permet d'inserer un customer
     * @param customer Le customer à insérer
     */
    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }

    public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }
}
