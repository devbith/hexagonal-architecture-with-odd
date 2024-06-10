package com.catalogservice.adapter.persistence;

import com.catalogservice.adapter.persistence.model.CatalogData;
import com.catalogservice.application.port.persistence.ReadCatalogPort;
import com.catalogservice.application.domain.Catalog;
import com.catalogservice.config.Adaptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Adaptor
public class ReadCatalogAdapter implements ReadCatalogPort {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReadCatalogAdapter.class);

  private final CatalogRepository catalogRepository;

  public ReadCatalogAdapter(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  @Override
  public boolean existCatalogById(Long catalogId) {
    return this.catalogRepository.existsById(catalogId);
  }

  @Override
  public Optional<Catalog> fetchById(Long catalogId) {
    Optional<CatalogData> catalogDataOptional = this.catalogRepository.findById(catalogId);
    LOGGER.info("Catalog fetched from database: {}", catalogDataOptional);
    return catalogDataOptional.map(CatalogData::mapToCatalog);
  }

  @Override
  public List<Catalog> fetchAll() {
    List<Catalog> catalogList = new ArrayList<>();
    for (CatalogData catalogData : this.catalogRepository.findAll()) {
      catalogList.add(catalogData.mapToCatalog());
    }
    return catalogList;
  }
}
