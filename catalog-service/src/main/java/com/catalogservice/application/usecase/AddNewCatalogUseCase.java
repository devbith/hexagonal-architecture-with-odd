package com.catalogservice.application.usecase;

import com.catalogservice.application.domain.Catalog;

public interface AddNewCatalogUseCase {

  Catalog save(Catalog catalog);
}
