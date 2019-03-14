package com.khoi.supplier.dao.dao.impl;

import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.supplier.dao.ISupplierDAO;
import com.khoi.supplier.dto.Supplier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SupplierDAOImpl extends BaseDAOImpl<Supplier, Integer> implements ISupplierDAO {

}
