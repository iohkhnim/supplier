package com.khoi.supplier.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_product")
public class Supplier_Product {

  @Column(name = "supplier_id")
  private
  int supplier_id;

  @Column(name = "prodcut_id")
  private
  int product_id;

  public int getSupplier_id() {
    return supplier_id;
  }

  public void setSupplier_id(int supplier_id) {
    this.supplier_id = supplier_id;
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }
}
