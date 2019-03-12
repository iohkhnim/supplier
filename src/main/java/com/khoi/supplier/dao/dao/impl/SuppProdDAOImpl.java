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

  @Override
  public Boolean create(Supplier_Product sp) {
    try {
      this.entityManager.persist(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  public Boolean update(Supplier_Product sp) {
    try {
      this.entityManager.merge(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}