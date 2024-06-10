package com.catalogservice.adapter.persistence;

import com.catalogservice.adapter.persistence.model.CatalogData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<CatalogData, Long> {

}
