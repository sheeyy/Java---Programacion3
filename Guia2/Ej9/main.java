package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        List<Producto>  lista =  productos.stream()
                .filter(producto -> producto.getStock() > 20)
                .map(p -> new Producto(p.getNombre(), p.getPrecio() * 1.15,p.getCategoria(), p.getStock()))
                .toList();
        }

    }

