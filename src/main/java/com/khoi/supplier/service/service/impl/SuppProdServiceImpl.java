package com.khoi.supplier.service.service.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dto.Supplier_Product;
import com.khoi.supplier.service.ISuppProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppProdServiceImpl implements ISuppProdService {

  @Autowired
  private ISuppProdDAO suppProdDAO;

  @Override
  public Boolean create(Supplier_Product sp) {
    try {
      suppProdDAO.create(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  public Boolean update(Supplier_Product sp) {
    try {
      suppProdDAO.update(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
