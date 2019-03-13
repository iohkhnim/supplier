package com.khoi.supplier.service;

import com.khoi.supplier.dto.Supplier_Product;
import java.util.List;

public interface ISuppProdService {

  Boolean create(Supplier_Product sp);

  Boolean update(Supplier_Product sp);

  List<Integer> getListProductIdBySupplierId(int supplier_id);
}
