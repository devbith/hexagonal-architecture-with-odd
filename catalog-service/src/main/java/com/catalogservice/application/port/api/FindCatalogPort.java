package com.catalogservice.application.port.api;

import com.catalogservice.adapter.api.model.CatalogDto;
import com.catalogservice.application.domain.Type;
import java.util.List;

public interface FindCatalogPort {

  List<CatalogDto> findAll();

  CatalogDto findById(Long id);

  List<CatalogDto> findByType(Type type);

}
