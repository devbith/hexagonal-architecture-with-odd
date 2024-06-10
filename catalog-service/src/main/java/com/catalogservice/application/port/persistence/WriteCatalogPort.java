package com.catalogservice.application.port.persistence;

import com.catalogservice.application.domain.Catalog;

public interface WriteCatalogPort {

  Catalog save(Catalog catalog);

  void deleteById(Long catalogId);

}
