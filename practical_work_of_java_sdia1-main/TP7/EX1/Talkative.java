package org.example.EX1;

public class Talkative implements Runnable {
    public static int number;
    public Talkative(int number) {
        Talkative.number = number;
    }

    @Override
    public void run() {
        for(int i=0; i<100 ; i++) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Talkative(1));
        Thread t2 = new Thread(new Talkative(2));
        Thread t3 = new Thread(new Talkative(3));
        Thread t4 = new Thread(new Talkative(4));
        Thread t5 = new Thread(new Talkative(5));
        Thread t6 = new Thread(new Talkative(6));
        Thread t7 = new Thread(new Talkative(7));
        Thread t8 = new Thread(new Talkative(8));
        Thread t9 = new Thread(new Talkative(9));
        Thread t10 = new Thread(new Talkative(10));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}

// tous les treads ont affiché la meme resultat '10'