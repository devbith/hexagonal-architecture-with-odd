package com.catalogservice.application.usecase;

import com.catalogservice.application.domain.Catalog;
import java.util.List;

public interface FindCatalogUseCase {

  Catalog findById(Long id);

  List<Catalog> findAll();
}
