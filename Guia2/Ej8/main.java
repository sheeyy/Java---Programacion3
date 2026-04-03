package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        Map<String,Long> cantidadPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));


        Map<String, Integer> resultado = productos.stream()
                .filter(producto -> cantidadPorCategoria.get(producto.getCategoria())  >= 3)
                .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.summingInt(Producto::getStock)));
    }
}
