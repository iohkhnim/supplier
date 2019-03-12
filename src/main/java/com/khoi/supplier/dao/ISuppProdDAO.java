package com.khoi.supplier.dao;

import com.khoi.supplier.dto.Supplier_Product;

public interface ISuppProdDAO {

  Boolean create(Supplier_Product sp);

  Boolean update(Supplier_Product sp);
}
