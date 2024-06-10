package com.catalogservice.application.service;

import com.catalogservice.application.port.persistence.ReadCatalogPort;
import com.catalogservice.application.port.persistence.WriteCatalogPort;
import com.catalogservice.config.UseCase;
import com.catalogservice.application.usecase.DeleteCatalogUseCase;

@UseCase
public class DeleteCatalogUseCaseService implements DeleteCatalogUseCase {

  private final WriteCatalogPort writeCatalogPort;
  private final ReadCatalogPort readCatalogPort;

  public DeleteCatalogUseCaseService(WriteCatalogPort writeCatalogPort, ReadCatalogPort readCatalogPort) {
    this.writeCatalogPort = writeCatalogPort;
    this.readCatalogPort = readCatalogPort;
  }

  @Override
  public void deleteById(Long catalogId) {
    if (this.readCatalogPort.existCatalogById(catalogId)) {
      this.writeCatalogPort.deleteById(catalogId);
    }
    throw new RuntimeException(String.format("Catalog with id %s not found", catalogId));
  }

}
