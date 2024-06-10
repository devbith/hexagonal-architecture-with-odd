package com.catalogservice.application.port.persistence;

import com.catalogservice.application.domain.Catalog;
import java.util.List;
import java.util.Optional;

public interface ReadCatalogPort {

  boolean existCatalogById(Long catalogId);

  Optional<Catalog> fetchById(Long catalogId);

  List<Catalog> fetchAll();

}
