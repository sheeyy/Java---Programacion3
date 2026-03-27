package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = List.of(8,5,2,1,3);
        lista.stream()
                .sorted()
                .forEach(System.out::println);

    }
}
