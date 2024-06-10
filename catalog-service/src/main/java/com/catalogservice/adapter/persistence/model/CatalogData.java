package com.catalogservice.adapter.persistence.model;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.domain.Price;
import com.catalogservice.application.domain.Type;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Currency;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "catalog_service", name = "catalog")
public record CatalogData(@Id Long id,
                          String name,
                          String currencyCode,
                          Double price,
                          String type,
                          OffsetDateTime createdAt,
                          OffsetDateTime updatedAt) {

  public static CatalogData mapFromCatalog(Catalog catalog) {
    final Price price = catalog.price();
    return new CatalogData(catalog.id(),
        catalog.name(),
        price.currency().getCurrencyCode(),
        price.value().doubleValue(),
        catalog.type().name(),
        catalog.createdAt(),
        catalog.updatedAt());
  }

  public Catalog mapToCatalog() {
    return new Catalog(this.id,
        this.name,
        new Price(BigDecimal.valueOf(this.price), Currency.getInstance(this.currencyCode)),
        Type.valueOf(this.type),
        this.createdAt,
        this.updatedAt
        );
  }
}
