package com.khoi.supplier.service.service.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dao.ISupplierDAO;
import com.khoi.supplier.dto.Supplier;
import com.khoi.supplierproto.GetSupplierListRequest;
import com.khoi.supplierproto.GetSupplierNameByIdRequest;
import com.khoi.supplierproto.GetSupplierNameByIdResponse;
import com.khoi.supplierproto.SupplierEntry;
import com.khoi.supplierproto.SupplierServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;
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
    List<Supplier> supplierList = supplierIdList.stream().map(p -> supplierDAO.findByid(p)).
        collect(Collectors.toList());

    supplierList.stream().forEach(e -> {
      responseObserver.onNext(e.toProto());
    });
    responseObserver.onCompleted();
  }

  @Override
  public void getSupplierNameById(GetSupplierNameByIdRequest request,
      StreamObserver<GetSupplierNameByIdResponse> streamObserver) {
    String supplier_name = supplierDAO.getSupplierNameById(request.getSupplierId());
    streamObserver.onNext(
        GetSupplierNameByIdResponse.newBuilder().setSupplierName(supplier_name).buildPartial());
    streamObserver.onCompleted();
  }

}
