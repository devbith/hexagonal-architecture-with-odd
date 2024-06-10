package com.catalogservice.adapter.api.model;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.domain.Catalog.CatalogBuilder;
import com.catalogservice.application.domain.Price;
import com.catalogservice.application.domain.Type;
import java.math.BigDecimal;
import java.util.Currency;

public record CatalogDto(Long id, String name, BigDecimal price, String currencyCode, String type) {

  public Catalog tranformToCatalog() {
    return CatalogBuilder.aCatalog()
        .withName(this.name())
        .withPrice(new Price(this.price(), Currency.getInstance(this.currencyCode())))
        .withType(Type.valueOf(this.type()))
        .build();

  }

  public static CatalogDto toCatalogDto(Catalog catalog) {
    return new CatalogDto(catalog.id(),
        catalog.name(),
        catalog.price().value(),
        catalog.price().currency().getCurrencyCode(),
        catalog.type().name());
  }

}
