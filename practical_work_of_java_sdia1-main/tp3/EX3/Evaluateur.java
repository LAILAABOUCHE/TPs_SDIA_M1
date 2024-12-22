package EX3;

public class Evaluateur {
    public Evaluateur(){};

    public void verifierNote(int number) throws NoteInvalideException{
        if(number < 0 || number >20) throw new NoteInvalideException(number);
    }

    public static void main(String[] args) {
        Evaluateur eval = new Evaluateur();

        try {
            eval.verifierNote(15);
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }

        try {
            eval.verifierNote(25);
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }

    }
}
