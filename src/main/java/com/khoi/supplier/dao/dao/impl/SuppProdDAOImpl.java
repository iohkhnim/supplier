package com.khoi.supplier.dao.dao.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dto.Supplier_Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SuppProdDAOImpl implements ISuppProdDAO {

  @PersistenceContext
  private EntityManager entityManager;

  public Supplier_Product findByid(int id) {
    Supplier_Product sp = entityManager.find(Supplier_Product.class, id);
    return sp;
  }

  @Override
  public Boolean create(Supplier_Product sp) {
    try {
      entityManager.persist(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  public Boolean update(Supplier_Product sp) {
    try {
      Supplier_Product sp_old = findByid(sp.getSupplier_id());
      sp_old.setProduct_id(sp.getProduct_id());
      sp_old.setSupplier_id(sp.getSupplier_id());
      entityManager.merge(sp_old);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}