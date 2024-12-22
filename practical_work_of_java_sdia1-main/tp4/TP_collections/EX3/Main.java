package TP_collections.EX3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> groupA = new HashSet<>();
        HashSet<String> groupB = new HashSet<>();
        groupA.add("a1");
        groupA.add("a2");
        groupA.add("a3");
        groupB.add("b1");
        groupB.add("b2");
        groupB.add("a2");
        groupB.add("a3");

        HashSet<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);

        HashSet<String> union = new HashSet<>(groupA);
        union.addAll(groupB);

        System.out.println(intersection);
        System.out.println(union);
    }
}
