import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String leVerbe;
        System.out.println("saisir un verbe du premier groupe : ");
        leVerbe = scanner.nextLine();

        leVerbe = leVerbe.substring(0, leVerbe.length() - 2);

        System.out.println("je " + leVerbe + "e");
        System.out.println("tu " + leVerbe + "es");
        System.out.println("il " + leVerbe + "e");
        System.out.println("nous " + leVerbe + "ons");
        System.out.println("vous " + leVerbe + "ez");
        System.out.println("ils " + leVerbe + "ent");
    }
}
