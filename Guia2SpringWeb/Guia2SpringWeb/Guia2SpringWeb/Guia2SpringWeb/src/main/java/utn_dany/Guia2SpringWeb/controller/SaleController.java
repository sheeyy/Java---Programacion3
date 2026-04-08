package utn_dany.Guia2SpringWeb.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn_dany.Guia2SpringWeb.model.CreateSale;
import utn_dany.Guia2SpringWeb.model.ProductEntity;
import utn_dany.Guia2SpringWeb.model.SaleEntity;
import utn_dany.Guia2SpringWeb.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;


   @GetMapping
    public ResponseEntity<List<SaleEntity>> getAll(){
       return ResponseEntity.ok(service.getAll());
   }

   @GetMapping("/{id}")
   public ResponseEntity<SaleEntity> getById(@PathVariable Long id) {
       return ResponseEntity.ok(service.getById(id));
   }

    @PostMapping
    public ResponseEntity<SaleEntity > create(@RequestBody CreateSale sale) {
        SaleEntity created = service.create(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
