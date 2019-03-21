package com.khoi.supplier;

import com.khoi.productproto.ProductServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  private final String productServiceEndpoint = "localhost:6575";

  @Bean(name = "productChannel")
  Channel productChannel() {
    return ManagedChannelBuilder.forTarget(productServiceEndpoint).usePlaintext().build();
  }

  @Bean(name = "productService")
  @Qualifier("productChannel")
  ProductServiceGrpc.ProductServiceBlockingStub priceService(Channel productChannel) {
    return ProductServiceGrpc.newBlockingStub(productChannel);
  }
}
