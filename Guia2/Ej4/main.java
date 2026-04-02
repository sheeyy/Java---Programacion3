package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
          Optional<String> Respuesta =     productos.stream()
                  .filter(producto -> producto.getCategoria().equals("Deportes"))
                  .filter(producto -> producto.getStock() > 10)
                  .map(producto -> producto.getNombre().toLowerCase())
                  .findFirst();

          if (Respuesta.isPresent()){
            System.out.println( Respuesta.get());
        } else {
            System.out.println("Optional vacio");
        }
    }

    }
