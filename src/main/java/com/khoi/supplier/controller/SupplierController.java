package com.khoi.supplier.controller;

import com.khoi.supplier.dto.Supplier;
import com.khoi.supplier.dto.Supplier_Product;
import com.khoi.supplier.service.ISuppProdService;
import com.khoi.supplier.service.ISupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("supplier")
public class SupplierController {

  @Autowired
  private ISupplierService supplierService;

  @Autowired
  private ISuppProdService suppProdService;
  
  @PostMapping("sp")
  public ResponseEntity<Void> createSP(@RequestBody Supplier_Product sp) {
    Boolean flag = suppProdService.create(sp);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @PutMapping("sp/update")
  public ResponseEntity<Void> updateSP(@RequestBody Supplier_Product sp) {
    Boolean flag = suppProdService.update(sp);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @GetMapping("findAll")
  public ResponseEntity<List<Supplier>> findAll() {
    List<Supplier> list = supplierService.findAll();
    return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
  }
}
