package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista2 = List.of(2,2,3,4,5);
        List<Integer> lista3 = lista2.stream()
                .distinct()
                .toList();
        System.out.println(lista3);

}

}
