package com.catalogservice.application.usecase;

import com.catalogservice.application.domain.Catalog;

public interface UpdateCatalogUseCase {

  Catalog update(Long catalogId, Catalog catalog);

}
