package Ex1;

public class Main {
    public static void main(String[] args) {
        Adherent adherent = new Adherent("dan", "bilzirian", "danbilzirian@gmail.com", "0664849382", 35, "938754");
        Livre livre = new Livre(980,new Auteur("cherlok", "holmez", "cherlokholems@gmail.com", "0600989382", 95, "445098"));
        System.out.println("les infos de l'adherent : ");
        adherent.afficher();
        System.out.println("les infos de livre : ");
        livre.afficher();
    }
}
