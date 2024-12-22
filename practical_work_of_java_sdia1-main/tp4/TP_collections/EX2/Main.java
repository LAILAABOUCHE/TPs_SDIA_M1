package TP_collections.EX2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> notes = new HashMap<String, Double>();
        notes.put("e1", 3.5);
        notes.put("e2", 5.5);
        notes.put("e3", 9.0);
        notes.put("e4", 10.0);
        notes.put("e2",notes.get("e2") + 5);
        System.out.println("la hashmap ------------>");
        notes.forEach((key,value) -> System.out.println(value));
        notes.remove("e1");
        System.out.println("la hashmap ------------>");
        notes.forEach((key,value) -> System.out.println(value));
        System.out.println("taille ------------>");
        System.out.println(notes.size());
        System.out.println("la hashmap ------------>");
        notes.forEach((key,value) -> System.out.println(value));
        double min = 0,max = 0,moy = 0;
        for(double v:notes.values()) {
            if(v>max) max = v;
            if(v<min) min = v;
            moy = moy + v;
        }
        moy = moy / notes.size();
        System.out.println("moy = " + moy + " | min = " + min + " | max = " + max);
        System.out.println("la hashmap ------------>");
        notes.forEach((key,value) -> System.out.println(value));
        boolean exists = false;
        for(double v : notes.values()) {
            if(v==20) exists = true;
        }
        if(exists) {
            System.out.println("il y a une note egale a 20");
        } else {
            System.out.println("il n'y a pas une note egale a 20");
        }
        System.out.println("la hashmap ------------>");
        notes.forEach((key,value) -> System.out.println(value));
//        System.out.println(notes.values().stream().mapToDouble(Double::doubleValue).min());


    }
}
