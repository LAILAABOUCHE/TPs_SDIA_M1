package Ex2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Employe ingenieur = new Ingenieur("elon","mask","jackdaniel00@gmail.com", "0660696664",10000.99,"ceo");
        Employe manager = new Manager("martin","turtini","jackdaniel00@gmail.com", "0660696664",10000.99,"commercial");
        System.out.println(ingenieur);
        System.out.println(manager);
    }
}