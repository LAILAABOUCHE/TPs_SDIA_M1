import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String s = "quelconque quelconque quelconque";
        do {
            System.out.println("saisi votre choix ? ");
            System.out.println("1 - saisir");
            System.out.println("2 - afficher");
            System.out.println("3 - inverser");
            System.out.println("4 - nombre de mots");
            System.out.println("0 - quitter");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    s = scanner.nextLine();
                    input.append(s);
                    break;
                case 2:
                    System.out.println(input);
                    break;
                case 3:
                    input.reverse();
                    break;
                case 4:
                    String[] list = input.toString().split(" ");
                    System.out.println(list.length);
                    break;
                default:
                    System.out.println("t'as pas saisir un choix predefinie");
                    break;
            }
            System.out.println("Frappez une touche pour revenir au menu");
            int a = scanner.nextInt();
        } while(choice != 0);
    }
}
