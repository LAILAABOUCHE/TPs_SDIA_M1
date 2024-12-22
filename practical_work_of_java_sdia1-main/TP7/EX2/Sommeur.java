package org.example.EX2;

public class Sommeur implements Runnable{
    private int[] tab;
    private int debut, fin;
    private static int somme;

    public Sommeur(int[] tab, int debut, int fin) {
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for(int i=debut ; i<fin ; i++) {
            synchronized (Sommeur.class) {
                somme+=tab[i];
            }
        }
    }

    public static int getSomme() {
        return Sommeur.somme;
    }


}
