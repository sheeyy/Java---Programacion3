package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> listaPalabras  = List.of("Palabra1","Palabra2");
        Map<Integer,List<String>> lista =  listaPalabras.stream()
                .collect(Collectors.groupingBy(String::length));
            System.out.println(lista);
        }
    }
