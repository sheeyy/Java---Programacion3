package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> paquete = List.of(1,2,3,4,5);
        Integer resultado = paquete.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x)
                .reduce(0,(a,b) -> a+b);
                System.out.println(resultado);
    }

}
