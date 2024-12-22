## Objectives
in this practical work we got the chance to get familiar with the concept of multithreading and concurrency in java, we have discovered the different methods of working with the threads such as  extending the `Thread` class or implementing the `Runnable` interface, as well as `synchronized` keyword that solve the problem of updating the same variable from the different threads. 
## Ex 1
- we create a class `Talkative` that contains a static integer `number`
- this class is implementing `Runnable` interface, when we do that we force it to override `run` method which will be executing when we start the thread.
```java
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
}
```
- in the main method we create 10 threads of `Talkative` class with different unique numbers.
```java
Thread t = new Thread(new Talkative(some_unique_number));
```
- we start all the thread with `start` method as we said before, and the `run` method automatically starts.
```java
t.start();
```
- when we execute our program and print the number it shows
```java
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
```
- this happened because all the thread are working on the same variable of the class `number`.
- so all the threads were updating the same variable.
## EX2
- first we create the `Sommeur` class which implements `Runnable` interface, eventually it will override the run method.
- the `Sommeur` class has three attributes, an array `int[] tab`, two integers `int debut; int fin` which represent the area of calculation, and a class variable `somme` which will hold our result of calculation which will be returned using the getter `getSomme()`.
```java
public class Sommeur implements Runnable {  
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
```
- in main we create three threads that will do the same thing which is calculating the sum of a field an array.
```java
public static void main(String[] args) {
	...
}
```
- first we create an array of n elements.
```java
int[] tab = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};  
```
- then we create three threads of `Sommeur` class, that will calculate the sum of three different fields of the same array.
```java
Thread t1 = new Thread(new Sommeur(tab,0,12));  
Thread t2 = new Thread(new Sommeur(tab,13,15));  
Thread t3 = new Thread(new Sommeur(tab,16,18));  
```
- we start the process by starting the threads.
```java
t1.start();
t2.start();
t3.start();
```
- but before printing the result we have to make sure that the thread ended the job so we use `join` method, and because it might throw `InterruptedException` we wrapped in try catch block
```java
try {  
	t1.join();  
	t2.join();  
	t3.join();  
} catch (InterruptedException e) {  
	throw new RuntimeException(e);  
}
```
- finally we print the result of sum.
```java
System.out.println("la somme totale est "+Sommeur.getSomme());
```
- we got the following result
```
la somme totale est 79

Process finished with exit code 0
```