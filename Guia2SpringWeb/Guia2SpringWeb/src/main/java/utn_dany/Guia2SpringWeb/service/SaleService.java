package utn_dany.Guia2SpringWeb.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn_dany.Guia2SpringWeb.model.ProductEntity;
import utn_dany.Guia2SpringWeb.model.SaleEntity;
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

        public List <SaleEntity> findAll(){
            return saleRepository.findAll();
        }

        public SaleEntity create(Long productId,Long userId,int quantity){

            ProductEntity existProductEntity = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Error al encontrar Producto"));


            if (!userRepository.findById(userId).isPresent()){
                throw new NoSuchElementException("Usuario inexistente");
            }


           if (!(quantity > 0)){
               throw new RuntimeException("Cantidad menor a 0");
           }

           if (!(existProductEntity.getStock() > quantity)){
               throw new RuntimeException("Cantidad de stock menor a "+quantity);
           }

           double precioTotal = existProductEntity.getPrice()*quantity;
           existProductEntity.setStock(existProductEntity.getStock()-quantity);

           SaleEntity saleEntity = new SaleEntity((saleRepository.findAll().size() + 1L),userId,productId,quantity,precioTotal);
            return saleRepository.save(saleEntity);
        }


        public SaleEntity update(Long ventaId,int quantity){

            SaleEntity existingVentaVieja = saleRepository.findById(ventaId).orElseThrow(() -> new RuntimeException("Error al encontrar VENTA"));
            long idProduct = existingVentaVieja.getProductId();
            ProductEntity existProductEntity = productRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Error al encontrar Producto"));

            if (!(quantity > 0)){
                throw new RuntimeException("Cantidad menor a 0");
            }


            int recalculoStock = existingVentaVieja.getQuantity() + existProductEntity.getStock();
            recalculoStock = recalculoStock - quantity;
            existProductEntity.setStock(recalculoStock);

            double precioTotal = existProductEntity.getPrice()*quantity;


            existingVentaVieja.setQuantity(quantity);
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

