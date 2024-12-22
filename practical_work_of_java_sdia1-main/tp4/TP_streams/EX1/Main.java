package TP_streams.EX1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        List<String> words = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon");
        System.out.println(words);
        List<String> first = words.stream().filter(word -> word.toLowerCase().contains("a")).toList();
        System.out.println(first);
        List<String> second = words.stream().filter(word -> word.length() > 3).map(word -> {
            input.delete(0, input.length());
            input.append(word);
            return input.reverse().toString();
        }).toList();
        System.out.println(second);
        List<char[]> third = words.stream().filter(word -> word.contains("e")).map(String::toCharArray).toList();
        third.forEach(System.out::println);
        List<String> forth = words.stream().map(String::toUpperCase).toList();
        System.out.println(forth);
        List<Integer> fifth = words.stream().map(String::length).toList();
        System.out.println(fifth);
        List<Character> sixth = words.stream().flatMap(word -> word.chars().mapToObj(c -> (char)c)).toList();
        System.out.println(sixth);
        List<String> seventh = IntStream.range(0, words.size())
                .mapToObj(index -> words.get(index) + " - " + index).toList();
        System.out.println(seventh);
    }
}
