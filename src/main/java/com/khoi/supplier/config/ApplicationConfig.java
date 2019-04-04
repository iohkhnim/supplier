package com.khoi.supplier.config;

import com.khoi.productproto.ProductServiceGrpc;
import io.grpc.Channel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class ApplicationConfig {

  private final String productServiceEndpoint = "172.17.0.2:6565";

  private final String productServerKeyPath = "key/product.crt";

  @Bean(name = "productChannel")
  Channel productChannel() throws Exception {
    return NettyChannelBuilder.forTarget(productServiceEndpoint)
        .negotiationType(NegotiationType.TLS)
        .sslContext(
            GrpcSslContexts.forClient().trustManager(new File(productServerKeyPath)).build())
        .build();
  }

  @Bean(name = "productService")
  @Qualifier("productChannel")
  ProductServiceGrpc.ProductServiceBlockingStub priceService(Channel productChannel) {
    return ProductServiceGrpc.newBlockingStub(productChannel);
  }
}
