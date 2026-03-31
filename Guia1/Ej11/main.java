package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int resultado = lista.stream()
                .reduce(1,(a,b) -> a*b);
                System.out.println(resultado);
        }
    }
