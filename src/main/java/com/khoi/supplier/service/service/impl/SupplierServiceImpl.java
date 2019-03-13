package com.khoi.supplier.service.service.impl;

import com.googlecode.protobuf.format.JsonFormat;
import com.khoi.basecrud.service.service.impl.BaseServiceImpl;
import com.khoi.productproto.GetProductRequest;
import com.khoi.productproto.ProductEntry;
import com.khoi.productproto.ProductServiceGrpc;
import com.khoi.supplier.dto.Supplier;
import com.khoi.supplier.service.ISuppProdService;
import com.khoi.supplier.service.ISupplierService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, Integer> implements
    ISupplierService {

  @Qualifier("poductService")
  private final ProductServiceGrpc.ProductServiceBlockingStub productService;
  @Autowired
  ISuppProdService suppProdService;

  public SupplierServiceImpl(ProductServiceGrpc.ProductServiceBlockingStub productService) {
    this.productService = productService;
  }

  @Override
  public Supplier findById(int id) {
    Supplier supplier = super.findByid(id);

    List<ProductEntry> productEntryList = new ArrayList<>();
    //get list of product
    List<Integer> list = suppProdService.getListProductIdBySupplierId(id);
    for (int i : list) {
      productEntryList
          .add(productService.getProduct(GetProductRequest.newBuilder().setProductId(i).build()));
    }

    List<String> productList = new ArrayList<>();
    for (ProductEntry entry : productEntryList) {
      productList.add(new JsonFormat().printToString(entry));
    }

    supplier.setProducts(productList);
    
    return supplier;
  }
}
