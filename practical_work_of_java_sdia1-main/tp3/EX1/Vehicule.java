package EX1;

public class Vehicule {
    public Vehicule() {}

    public void testVitesse(int vitesse) throws TropViteException{
        if (vitesse > 90) throw new TropViteException(vitesse);
    }

    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();

        try {
            vehicule.testVitesse(80);
        } catch (TropViteException e) {
            e.printStackTrace();
        }

        try {
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            e.printStackTrace();
        }
    }
}

