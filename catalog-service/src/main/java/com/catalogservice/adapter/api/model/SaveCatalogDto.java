package com.catalogservice.adapter.api.model;

import java.math.BigDecimal;

public record SaveCatalogDto(String name, BigDecimal price, String currencyCode, String type) {

  public CatalogDto catalogDto() {
    return new CatalogDto(0l, name, price, currencyCode, type);
  }
}
