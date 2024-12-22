package TP_streams.EX2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employe> employes = new ArrayList<>();

        employes.add(new Employe("Alice", "IT", 60000));
        employes.add(new Employe("Bob", "HR", 55000));
        employes.add(new Employe("Charlie", "Finance", 65000));
        employes.add(new Employe("David", "Marketing", 50000));
        employes.add(new Employe("Eva", "IT", 62000));
        employes.add(new Employe("Frank", "HR", 53000));
        employes.add(new Employe("Grace", "Finance", 70000));
        employes.add(new Employe("Henry", "Marketing", 48000));
        employes.add(new Employe("Ivy", "IT", 67000));
        employes.add(new Employe("Jack", "Finance", 75000));

        double sum = employes.stream().mapToDouble(Employe::getSalaire).reduce(0.0, Double::sum);
        System.out.println("sum : " + sum);

        List<String> sorted = employes.stream().map(Employe::getNom).sorted().toList();
        System.out.println(sorted);

        double minValue = employes.stream().map(Employe::getSalaire).min(Double::compareTo).get();
        Employe minEmploye = employes.stream().filter(e -> e.getSalaire() == minValue).findFirst().get();
        System.out.println(minEmploye.toString());

        List<Employe> someEmployes = employes.stream().filter(e -> e.getSalaire() == 90000).toList();

        double maxValue = employes.stream().mapToDouble(Employe::getSalaire).reduce(Math::max).getAsDouble();
        Employe maxEmploye = employes.stream().filter(e -> e.getSalaire() == maxValue).findFirst().get();
        System.out.println(maxEmploye.toString());

        String noms = employes.stream().map(Employe::getNom).reduce((a,b) -> a + " " + b).get();
        System.out.println(noms);
    }
}
