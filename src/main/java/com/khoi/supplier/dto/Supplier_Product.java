package com.khoi.supplier.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "supplier_product")
public class Supplier_Product implements Serializable {

  @Column(name = "supplier_id")
  private
  int supplier_id;

  @Column(name = "product_id")
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
