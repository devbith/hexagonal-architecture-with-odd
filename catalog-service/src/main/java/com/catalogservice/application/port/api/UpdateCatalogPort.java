package com.catalogservice.application.port.api;

import com.catalogservice.adapter.api.model.CatalogDto;

public interface UpdateCatalogPort {

  CatalogDto save(CatalogDto catalogDto);

  CatalogDto update(Long catalogId, CatalogDto updatedCatalogDto);

  void delete(Long catalogId);

}
