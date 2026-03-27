package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = List.of(8,5,2,1,3);
        long cantMayores7 = lista.stream()
                .filter(elemento -> elemento > 7)
                .count();

    }
}
