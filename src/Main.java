import due.Due;
import otto.Otto;
import quattro.Quattro;
import sette.Sette;
import tre.Tre;
import uno.Uno;

public class Main {
    public static void main(String[] args) throws Exception {

        var uno = new Uno();
        var due = new Due();
        var tre = new Tre();
        var quattro = new Quattro();
        var sette = new Sette();
        var otto = new Otto();

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
        System.out.println("Giorno 7!");
        sette.game();
        sette.gioco2();
        System.out.println("Giorno 8!");
        otto.gioco();
        otto.gioco2();

    }
}