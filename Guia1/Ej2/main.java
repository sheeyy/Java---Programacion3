package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("Hola","Chau");
        list.stream()
                .map(elemento -> elemento.toUpperCase())
                .forEach(System.out::println);

    }
}

