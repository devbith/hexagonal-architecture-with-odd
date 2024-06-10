package com.catalogservice.application.service;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.domain.Catalog.CatalogBuilder;
import com.catalogservice.application.port.persistence.ReadCatalogPort;
import com.catalogservice.application.port.persistence.WriteCatalogPort;
import com.catalogservice.config.UseCase;
import com.catalogservice.application.usecase.UpdateCatalogUseCase;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@UseCase
public class UpdateCatalogUseCaseService implements UpdateCatalogUseCase {

  private final WriteCatalogPort writeCatalogPort;
  private final ReadCatalogPort readCatalogPort;

  public UpdateCatalogUseCaseService(WriteCatalogPort writeCatalogPort, ReadCatalogPort readCatalogPort) {
    this.writeCatalogPort = writeCatalogPort;
    this.readCatalogPort = readCatalogPort;
  }

  @Override
  public Catalog update(Long catalogId, Catalog catalog) {
    if (Objects.isNull(catalogId) && Objects.isNull(catalog)) {
      throw new IllegalArgumentException("CatalogId can't be null");
    }
    final Optional<Catalog> catalogFromDbOptional = this.readCatalogPort.fetchById(catalogId);
    if (catalogFromDbOptional.isEmpty()) {
      throw new IllegalArgumentException(String.format("CatalogId %s not found in database", catalogId));
    }

    final Catalog catalogFromDb = catalogFromDbOptional.get();
    final Catalog catalogToUpdate = new CatalogBuilder(catalogFromDb)
        .withUpdatedAt(OffsetDateTime.now())
        .withPrice(catalog.price())
        .withType(catalog.type())
        .withName(catalog.name())
        .build();

    return writeCatalogPort.save(catalogToUpdate);
  }
}
