package com.catalogservice.application.service;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.domain.Catalog.CatalogBuilder;
import com.catalogservice.application.port.persistence.WriteCatalogPort;
import com.catalogservice.application.usecase.AddNewCatalogUseCase;
import com.catalogservice.config.UseCase;
import java.time.OffsetDateTime;

@UseCase
public class AddNewCatalogUseCaseService implements AddNewCatalogUseCase {

  private final WriteCatalogPort writeCatalogPort;

  public AddNewCatalogUseCaseService(WriteCatalogPort writeCatalogPort) {
    this.writeCatalogPort = writeCatalogPort;
  }

  @Override
  public Catalog save(Catalog catalog) {
    final OffsetDateTime createdAt = OffsetDateTime.now();
    final Catalog updatedCatalog = new CatalogBuilder(catalog).withCreatedAt(createdAt)
        .withUpdatedAt(createdAt)
        .build();
    return writeCatalogPort.save(updatedCatalog);
  }

}
