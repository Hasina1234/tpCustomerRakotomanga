/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rakotomanga.tpcustomerrakotomanga.jsf;

import com.rakotomanga.tpcustomerrakotomanga.entity.Discount;
import com.rakotomanga.tpcustomerrakotomanga.service.DiscountManager;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

/**
 *
 * @author Hasina
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount> {
  @Inject
  private DiscountManager discountManager;

  /**
   * Convertit une String en Discount.
   *
   * @param value valeur à convertir
   */
  @Override
  public Discount getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return discountManager.findById(value);
  }

  /**
   * Convertit un Discount en String.
   *
   * @param value valeur à convertir
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Discount discount) {
    if (discount == null) return "";
    return discount.getCode();
  }
}
