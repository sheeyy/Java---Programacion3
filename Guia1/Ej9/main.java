package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<Integer> listaEnteros = List.of(1,2,3,4,5);
        List<Integer> lista5 =  listaEnteros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();

        System.out.println(lista5);

}

}
