package org.example;

import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        double gananciaTotal = productos.stream()
                .map(p -> p.getCategoria().equals("Electronica") ? p.getPrecio() * 0.65 * p.getStock() : p.getPrecio() * 0.45 * p.getStock())
                .reduce(0.0,(a, b) -> a + b);
                System.out.println("Costo total: " + gananciaTotal);
                
        //INCOMPLETO
    }

}

