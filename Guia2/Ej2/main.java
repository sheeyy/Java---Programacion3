package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Producto> lista = Producto.cargarProductos();
        double promedio = lista.stream()
                .filter(producto -> producto.getCategoria().equals("Hogar"))
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);


        System.out.println(promedio);
    }

}
