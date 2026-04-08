package utn_dany.Guia2SpringWeb.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn_dany.Guia2SpringWeb.model.CreateSale;
import utn_dany.Guia2SpringWeb.model.ProductEntity;
import utn_dany.Guia2SpringWeb.model.SaleEntity;
import utn_dany.Guia2SpringWeb.model.SaleUpdate;
import utn_dany.Guia2SpringWeb.repository.ProductRepository;
import utn_dany.Guia2SpringWeb.repository.SaleRepository;
import utn_dany.Guia2SpringWeb.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

        public List<SaleEntity> getAll() {
            return saleRepository.findAll();
        }

         public SaleEntity getById(Long id) {
            return saleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
    }


        public SaleEntity create(CreateSale sale){

            ProductEntity exists = productService.getById(sale.getProductId());

            ProductEntity existProductEntity = productRepository
                    .findById(sale.getProductId())
                    .orElseThrow(() -> new RuntimeException("Error al encontrar Producto"));


            if (!userRepository.findById(sale.getProductId()).isPresent()){
                throw new NoSuchElementException("Usuario inexistente");
            }


           if (!(sale.getQuantity() > 0)){
               throw new RuntimeException("Cantidad menor a 0");
           }

           if (!(existProductEntity.getStock() > sale.getQuantity())){
               throw new RuntimeException("Cantidad de stock menor a "+sale.getQuantity());
           }

           double precioTotal = existProductEntity.getPrice()*sale.getQuantity();
           existProductEntity.setStock(existProductEntity.getStock()-sale.getQuantity());

           SaleEntity saleEntity = new SaleEntity((saleRepository.findAll().size() + 1L),sale.getUserId(),sale.getProductId(),sale.getQuantity(),precioTotal);
            return saleRepository.save(saleEntity);
        }


        public SaleEntity update(Long ventaId, SaleUpdate update){

            SaleEntity existingVentaVieja = saleRepository.findById(ventaId).orElseThrow(() -> new RuntimeException("Error al encontrar VENTA"));
            long idProduct = existingVentaVieja.getProductId();
            ProductEntity existProductEntity = productRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Error al encontrar Producto"));

            if (!(update.getQuantity() > 0)){
                throw new RuntimeException("Cantidad menor a 0");
            }


            int recalculoStock = existingVentaVieja.getQuantity() + existProductEntity.getStock();
            recalculoStock = recalculoStock - update.getQuantity();
            existProductEntity.setStock(recalculoStock);

            double precioTotal = existProductEntity.getPrice()*update.getQuantity();


            existingVentaVieja.setQuantity(update.getQuantity());
            existingVentaVieja.setTotalPrice(precioTotal);

            return saleRepository.update(existingVentaVieja).orElseThrow(() -> new RuntimeException("Error al updatear"));
        }

        public void delete(Long ventaiD){

            SaleEntity existing = saleRepository.findById(ventaiD).orElseThrow(() -> new RuntimeException("Error al encontrar"));

            if (!saleRepository.delete(existing)){
                throw new RuntimeException("Error al borrar");
            }


        }

}

