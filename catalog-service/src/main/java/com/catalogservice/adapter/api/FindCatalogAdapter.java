package com.catalogservice.adapter.api;

import com.catalogservice.adapter.api.model.CatalogDto;
import com.catalogservice.application.port.api.FindCatalogPort;
import com.catalogservice.application.usecase.FindCatalogUseCase;
import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.domain.Type;
import com.catalogservice.config.Adaptor;
import java.util.List;
import java.util.stream.Collectors;

@Adaptor
public class FindCatalogAdapter implements FindCatalogPort {

  private final FindCatalogUseCase findCatalogUseCase;

  public FindCatalogAdapter(FindCatalogUseCase findCatalogUseCase) {
    this.findCatalogUseCase = findCatalogUseCase;
  }

  @Override
  public List<CatalogDto> findAll() {
    return findCatalogUseCase.findAll()
        .stream()
        .map(CatalogDto::toCatalogDto)
        .collect(Collectors.toList());
  }

  @Override
  public CatalogDto findById(Long id) {
    Catalog catalog = this.findCatalogUseCase.findById(id);
    return CatalogDto.toCatalogDto(catalog);
  }

  @Override
  public List<CatalogDto> findByType(Type type) {
    // Todo
    return null;
  }
}
