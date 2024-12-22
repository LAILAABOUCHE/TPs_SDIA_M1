import java.util.Arrays;
import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombreEtudiants;

        System.out.println("Ecrire le nombre des etudiants");
        nombreEtudiants = scanner.nextInt();
        float[] notes = new float[nombreEtudiants];

        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.print("Entrez la note pour l'étudiant " + (i + 1) + " : ");
            notes[i] = scanner.nextFloat();
        }

        // 1. Triez et afficher la liste des notes
        Arrays.sort(notes);
        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.print("la note d'étudiant " + (i + 1) + " : " + notes[i] + "\n");
        }

        // 2. Affichez la note moyenne.
        float moy = 0;
        for (int i = 0; i < nombreEtudiants; i++) {
            moy += notes[i];
        }
        System.out.println("la moyen des notes est : "+moy/nombreEtudiants);

        // 3. Affichez la note maximale et minimale.
        int min = 0, max = 0;
        for (int i = 1; i < nombreEtudiants; i++) {
            if(notes[i] < notes[min]) {
                min = i;
            }
            if(notes[i] > notes[max]) {
                max = i;
            }
        }
        System.out.println("la note minimale est : "+ notes[min]);
        System.out.println("la note maximale est : "+ notes[max]);

        // 4. Affichez le nombre d’étudiants ayant une note saisie par l’utilisateur.
        System.out.println("saisir une note : ");
        float noteSaisie = scanner.nextFloat();
        int conteur = 0;
        for (int i = 1; i < nombreEtudiants; i++) {
            if(notes[i] == noteSaisie) {
                conteur++;
            }
        }
        System.out.println("le nombre des etudiant ayant la note " + noteSaisie + " sont : " + conteur);
    }
}
