package com.khoi.supplier.service;

import com.khoi.basecrud.service.IBaseService;
import com.khoi.supplier.dto.Supplier;

public interface ISupplierService extends IBaseService<Supplier, Integer> {

  Supplier findById(int supplier_id);
}
