package com.catalogservice.adapter.api;

import com.catalogservice.adapter.api.model.CatalogDto;
import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.port.api.UpdateCatalogPort;
import com.catalogservice.application.usecase.AddNewCatalogUseCase;
import com.catalogservice.application.usecase.DeleteCatalogUseCase;
import com.catalogservice.config.Adaptor;
import com.catalogservice.application.usecase.UpdateCatalogUseCase;

@Adaptor
public class UpdateCatalogAdaptor implements UpdateCatalogPort {

  private final AddNewCatalogUseCase addNewCatalogUseCase;
  private final UpdateCatalogUseCase updateCatalogUseCase;
  private final DeleteCatalogUseCase deleteCatalogUseCase;

  public UpdateCatalogAdaptor(AddNewCatalogUseCase addNewCatalogUseCase, UpdateCatalogUseCase updateCatalogUseCase,
      DeleteCatalogUseCase deleteCatalogUseCase) {
    this.addNewCatalogUseCase = addNewCatalogUseCase;
    this.updateCatalogUseCase = updateCatalogUseCase;
    this.deleteCatalogUseCase = deleteCatalogUseCase;
  }

  @Override
  public CatalogDto save(CatalogDto catalogDto) {
    Catalog savedCatalog = addNewCatalogUseCase.save(catalogDto.tranformToCatalog());
    return CatalogDto.toCatalogDto(savedCatalog);
  }

  @Override
  public CatalogDto update(Long catalogId, CatalogDto updatedCatalogDto) {
    Catalog updatedCatalog = this.updateCatalogUseCase.update(catalogId, updatedCatalogDto.tranformToCatalog());
    return CatalogDto.toCatalogDto(updatedCatalog);
  }

  @Override
  public void delete(Long catalogId) {
    deleteCatalogUseCase.deleteById(catalogId);
  }
}
