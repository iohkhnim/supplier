package com.khoi.supplier.service.service.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dto.Supplier_Product;
import com.khoi.supplier.service.ISuppProdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppProdServiceImpl implements ISuppProdService {

  @Autowired
  private ISuppProdDAO suppProdDAO;

  /**
   * <p>This method passes value to DAO in order to create a Supplier_Product in database</p>
   *
   * @param sp Supplier_Product object contains information
   * @return Return a boolean value according to result
   */
  @Override
  public Boolean create(Supplier_Product sp) {
    try {
      suppProdDAO.create(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /**
   * <p>This method passes value to DAO in order to update a Supplier_Product in database</p>
   *
   * @param sp Supplier_Product object contains information
   * @return Return a boolean value according to result
   */
  @Override
  public Boolean update(Supplier_Product sp) {
    try {
      suppProdDAO.update(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /**
   * <p>This method passes value to DAO in order to get a list of product ID sold by given
   * supplier</p>
   *
   * @param supplier_id supplier ID needs to be retrieved its product id
   * @return List of product ID sold by given supplier
   */
  @Override
  public List<Integer> getListProductIdBySupplierId(int supplier_id) {
    return suppProdDAO.getListProductIdBySupplierId(supplier_id);
  }

  /**
   * <p>This method passes value to DAO in order to get a list of supplier ID supply given
   * product</p>
   *
   * @param product_id product ID needs to be retrieves its suppliers
   * @return List of supplier ID supply given product
   */
  @Override
  public List<Integer> getListSupplierIdByProductId(int product_id) {
    return suppProdDAO.getListSupplierIdByProductId(product_id);
  }
}
