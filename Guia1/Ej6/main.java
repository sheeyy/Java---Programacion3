package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lista1 = List.of("Palabra1","Palabra10");
        List<Integer> lista2 =  lista1.stream()
                .map(elemento -> elemento.length())
                .toList();

        System.out.println(lista2);



}
}
