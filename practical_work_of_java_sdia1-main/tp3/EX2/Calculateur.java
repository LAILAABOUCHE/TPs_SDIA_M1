package EX2;

public class Calculateur {
    public Calculateur() {};

    public void testRacineCarree(int number) throws RacineCarreeException{
        if(number < 0) throw new RacineCarreeException(number);
    }

    public static void main(String[] args) {
        Calculateur calc = new Calculateur();

        try {
            calc.testRacineCarree(-5);
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }

        try {
            calc.testRacineCarree(25);
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }
    }
}
