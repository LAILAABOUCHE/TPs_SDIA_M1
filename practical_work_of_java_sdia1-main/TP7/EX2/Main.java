package org.example.EX2;

public class Main {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
        Thread t1 = new Thread(new Sommeur(tab,0,12));
        Thread t2 = new Thread(new Sommeur(tab,13,15));
        Thread t3 = new Thread(new Sommeur(tab,16,18));
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("la somme totale est "+Sommeur.getSomme());
    }
}
