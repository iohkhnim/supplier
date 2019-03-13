package com.khoi.supplier.service.service.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dao.ISupplierDAO;
import com.khoi.supplier.dto.Supplier;
import com.khoi.supplierproto.GetSupplierListRequest;
import com.khoi.supplierproto.SupplierEntry;
import com.khoi.supplierproto.SupplierServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class SupplierServiceGrpcImpl extends SupplierServiceGrpc.SupplierServiceImplBase {

  @Autowired
  ISupplierDAO supplierDAO;

  @Autowired
  ISuppProdDAO suppProdDAO;

  @Override
  public void getSupplierListByProductId(GetSupplierListRequest request,
      StreamObserver<SupplierEntry> responseObserver) {
    //get supplier id list
    List<Integer> supplierIdList = suppProdDAO.getListSupplierIdByProductId(request.getProductId());
    List<Supplier> supplierList = new ArrayList<>();
    for (int i : supplierIdList) {
      supplierList.add(supplierDAO.findByid(i));
    }
    supplierList.forEach(e -> {
      responseObserver.onNext(e.toProto());
    });
    responseObserver.onCompleted();
  }

}
