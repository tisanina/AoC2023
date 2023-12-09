import due.Due;
import uno.Uno;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        var uno = new Uno();
        var due = new Due();
        System.out.println("Giorno 1!");
        uno.gioco();
        uno.gioco2();
        System.out.println("Giorno 2!");
        due.gioco();
        due.gioco2();

    }
}