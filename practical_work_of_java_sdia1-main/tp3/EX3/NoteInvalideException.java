package EX3;

public class NoteInvalideException extends Exception {
    public NoteInvalideException(int number) {
        super("Exception de type NoteInvalideException. Note invalide : " + number);
    }
}

