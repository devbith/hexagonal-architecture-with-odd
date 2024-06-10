package com.catalogservice;

import com.catalogservice.config.UseCase;
import com.catalogservice.config.Adaptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    basePackages = "com.observability.catalogservice",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Adaptor.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class)
    }
)
public class CatalogServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CatalogServiceApplication.class, args);
  }

}
