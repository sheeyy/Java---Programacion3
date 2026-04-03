package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        double promedio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        int totalStock = productos.stream()
                .filter(producto -> producto.getPrecio() > promedio)
                .mapToInt(Producto::getStock)
                .sum();

    }
}
