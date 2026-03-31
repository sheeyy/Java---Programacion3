package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> paquete = List.of(1,2,3,4,5);
        String resultado = paquete.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println(resultado);
    }
}
