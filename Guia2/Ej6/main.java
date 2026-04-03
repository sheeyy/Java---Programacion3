package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        List<String> listaResultadoStrings =  productos.stream()
                .filter(producto -> producto.getStock() > 0)
                .map(Producto::getNombre)
                .sorted()
                .filter(producto -> producto.length() >= 5)
                .toList();
    }
    }
