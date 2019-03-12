package com.khoi.supplier.service;

import com.khoi.supplier.dto.Supplier_Product;

public interface ISuppProdService {

  Boolean create(Supplier_Product sp);

  Boolean update(Supplier_Product sp);
}
