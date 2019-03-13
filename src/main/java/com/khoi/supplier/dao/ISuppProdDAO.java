package com.khoi.supplier.dao;

import com.khoi.supplier.dto.Supplier_Product;
import java.util.List;

public interface ISuppProdDAO {

  Boolean create(Supplier_Product sp);

  Boolean update(Supplier_Product sp);

  List<Integer> getListProductIdBySupplierId(int supplier_id);

  List<Integer> getListSupplierIdByProductId(int product_id);
}
