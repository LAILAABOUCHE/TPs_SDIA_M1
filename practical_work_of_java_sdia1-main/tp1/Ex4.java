import java.util.Locale;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        int[] tab = new int[26];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire une chaine de charactere : ");
        String text = scanner.nextLine();
        char[] charArray = text.toUpperCase().toCharArray();

        for(int i = 0 ; i < 26 ; i++) {
            for(char c: charArray) {
                if(((int)c) == i+65) {
                    tab[i]++;
                }
            }
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(tab[i] > 0) {
                System.out.println(tab[i] + " fois la lettre " + (char)(i+65));
            }
        }
    }
}
