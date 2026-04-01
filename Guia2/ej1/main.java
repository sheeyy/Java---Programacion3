package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Producto> lista = Producto.cargarProductos();
        List<Producto> listaMayor = lista.stream()
                .filter(producto -> producto.getCategoria().equals("Electrónica"))
                .filter(producto -> producto.getPrecio() > 1000)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .toList();
                System.out.println(listaMayor);
    }

}
