/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rakotomanga.tpcustomerrakotomanga.service;

import com.rakotomanga.tpcustomerrakotomanga.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 * Façade pour gérer les Customers. Elle contient des méthodes pour récupérer
 * tous les discounts,
 *
 * @author Hasina
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "discountPU")
    private EntityManager em;

    /**
     * GetAllCustomer permet d'avoir la list des customer
     *
     * @return
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

}
