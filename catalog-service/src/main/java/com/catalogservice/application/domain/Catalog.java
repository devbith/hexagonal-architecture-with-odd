package com.catalogservice.application.domain;

import java.time.OffsetDateTime;

public record Catalog(Long id, String name, Price price, Type type, OffsetDateTime createdAt, OffsetDateTime updatedAt) {


  public static final class CatalogBuilder {

    private Long id;
    private String name;
    private Price price;
    private Type type;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public CatalogBuilder() {
    }

    public CatalogBuilder(Catalog other) {
      this.id = other.id();
      this.name = other.name();
      this.price = other.price();
      this.type = other.type();
      this.createdAt = other.createdAt();
      this.updatedAt = other.updatedAt();
    }

    public static CatalogBuilder aCatalog() {
      return new CatalogBuilder();
    }

    public CatalogBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public CatalogBuilder withName(String name) {
      this.name = name;
      return this;
    }

    public CatalogBuilder withPrice(Price price) {
      this.price = price;
      return this;
    }

    public CatalogBuilder withType(Type type) {
      this.type = type;
      return this;
    }

    public CatalogBuilder withCreatedAt(OffsetDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public CatalogBuilder withUpdatedAt(OffsetDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Catalog build() {
      return new Catalog(id, name, price, type, createdAt, updatedAt);
    }
  }
}
