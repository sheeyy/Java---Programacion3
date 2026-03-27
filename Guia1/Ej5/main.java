package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> lista2 = lista.stream()
                .limit(5)
                .toList();

        System.out.println(lista2);
    }

}
