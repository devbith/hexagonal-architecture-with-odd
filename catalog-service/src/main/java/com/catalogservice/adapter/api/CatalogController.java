package com.catalogservice.adapter.api;

import com.catalogservice.adapter.api.model.CatalogDto;
import com.catalogservice.adapter.api.model.SaveCatalogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class CatalogController {

  private final UpdateCatalogAdaptor catalogUpdateAdaptor;
  private final FindCatalogAdapter findCatalogAdapter;

  public CatalogController(UpdateCatalogAdaptor catalogUpdateAdaptor, FindCatalogAdapter findCatalogAdapter) {
    this.catalogUpdateAdaptor = catalogUpdateAdaptor;
    this.findCatalogAdapter = findCatalogAdapter;
  }

  @PostMapping("/catalog")
  public ResponseEntity<CatalogDto> saveCatalog(@RequestBody SaveCatalogDto saveCatalogDto) {
    CatalogDto createdCatalog = catalogUpdateAdaptor.save(saveCatalogDto.catalogDto());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCatalog);
  }

  @PutMapping("/catalog/{catalogId}")
  public ResponseEntity<CatalogDto> updateCatalog(@PathVariable Long catalogId, @RequestBody SaveCatalogDto catalogDto) {
    CatalogDto updateCatalog = catalogUpdateAdaptor.update(catalogId, catalogDto.catalogDto());
    return ResponseEntity.status(HttpStatus.OK).body(updateCatalog);
  }

  @GetMapping("/catalog/{catalogId}")
  public ResponseEntity<CatalogDto> getCatalog(@PathVariable Long catalogId) {
    CatalogDto catalogDto = findCatalogAdapter.findById(catalogId);
    return ResponseEntity.status(HttpStatus.OK).body(catalogDto);
  }

  @DeleteMapping("/catalog/{catalogId}")
  public ResponseEntity<Void> deleteCatalog(@PathVariable Long catalogId) {
    return ResponseEntity.noContent().build();
  }

}
