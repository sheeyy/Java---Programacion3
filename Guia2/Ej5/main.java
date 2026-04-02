package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();

        Optional<Producto> min = productos.stream()
                .min(Comparator.comparingDouble(Producto -> Producto.getPrecio() * Producto.getPrecio()));
    }
    }
