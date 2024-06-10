package com.catalogservice.adapter.persistence;

import com.catalogservice.application.domain.Catalog;
import com.catalogservice.application.port.persistence.WriteCatalogPort;
import com.catalogservice.adapter.persistence.model.CatalogData;
import com.catalogservice.config.Adaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Adaptor
public class WriteCatalogAdaptor implements WriteCatalogPort {

  private static final Logger LOGGER = LoggerFactory.getLogger(WriteCatalogAdaptor.class);

  private final CatalogRepository catalogRepository;

  public WriteCatalogAdaptor(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  @Override
  public Catalog save(Catalog catalog) {
    CatalogData savedData = this.catalogRepository.save(CatalogData.mapFromCatalog(catalog));
    LOGGER.info("Catalog saved into database: {}", savedData);
    return savedData.mapToCatalog();
  }

  @Override
  public void deleteById(Long catalogId) {
    this.catalogRepository.deleteById(catalogId);
    LOGGER.info("Catalog with id {} delete", catalogId);
  }

}
