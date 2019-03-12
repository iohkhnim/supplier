package com.khoi.supplier;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupplierApplication {

  @PostConstruct
  public void init() {
    // Setting Spring Boot SetTimeZone
    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
  }

  public static void main(String[] args) {
    SpringApplication.run(SupplierApplication.class, args);
  }

}
