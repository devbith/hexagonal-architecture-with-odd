package com.catalogservice.application.service;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.port.persistence.ReadCatalogPort;
import com.catalogservice.application.usecase.FindCatalogUseCase;
import com.catalogservice.config.UseCase;
import java.util.List;

@UseCase
public class FindCatalogUseCaseService implements FindCatalogUseCase {

  private final ReadCatalogPort readCatalogPort;

  public FindCatalogUseCaseService(ReadCatalogPort readCatalogPort) {
    this.readCatalogPort = readCatalogPort;
  }

  @Override
  public Catalog findById(Long id) {
    return readCatalogPort.fetchById(id).get();
  }

  @Override
  public List<Catalog> findAll() {
    return readCatalogPort.fetchAll();
  }
}
