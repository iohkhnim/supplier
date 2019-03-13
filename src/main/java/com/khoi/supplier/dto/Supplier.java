package com.khoi.supplier.dto;

import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "supplier")
public class Supplier extends baseDTO implements Serializable {

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Transient
  private List<String> products;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<String> getProducts() {
    return products;
  }

  public void setProducts(List<String> products) {
    this.products = products;
  }
}
