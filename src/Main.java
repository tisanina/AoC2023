import due.Due;
import quattro.Quattro;
import tre.Tre;
import uno.Uno;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        var uno = new Uno();
        var due = new Due();
        var tre = new Tre();
        var quattro = new Quattro();

        System.out.println("Giorno 1!");
        uno.gioco();
        uno.gioco2();
        System.out.println("Giorno 2!");
        due.gioco();
        due.gioco2();
        System.out.println("Giorno 3!");
        tre.gioco();
        System.out.println("Giorno 4!");
        quattro.gioco();
        quattro.gioco2();

    }
}