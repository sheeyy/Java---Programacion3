package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<String> lista1 = List.of("Palabra1","Palabra10");
        Optional<String> concatenado =  lista1.stream()
                .reduce((a, b) -> a + "," + b);

        System.out.println(concatenado);
}
}
