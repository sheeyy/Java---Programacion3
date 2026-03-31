package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> paquete = List.of("Palabra1","Palabra29");
        Optional<String> mayorPalabra = paquete.stream()
                .max(Comparator.comparing(String::length));

        System.out.println(mayorPalabra.get());
    }
}
