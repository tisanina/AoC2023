package uno;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Uno {

    public void gioco() throws IOException {
        var fileName = "src/uno/uno.txt";
        var path = Path.of(fileName);
        var linee = Files.readAllLines(path, StandardCharsets.UTF_8);

        var somma = 0;
        for (var linea : linee) {
            var caratteri = linea.split("");
            var caratterePrimo = "";
            var carattereUltimo = "";
            var numero = 0;
            for (int i = 0; i < linea.length(); i++) {
                try {

                    if (this.isDigit(caratteri[i])) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = caratteri[i];
                        } else {
                            carattereUltimo = caratteri[i];
                        }
                    }
                } catch (Exception e) {

                }
            }

            if (carattereUltimo.isBlank()){
                carattereUltimo = caratterePrimo;
            }
            numero = Integer.parseInt(caratterePrimo + carattereUltimo);
            somma += numero;
        }

        System.out.println(somma);
    }


    public void gioco2() throws IOException {
        var fileName = "src/uno/uno.txt";
        var path = Path.of(fileName);
        var linee = Files.readAllLines(path, StandardCharsets.UTF_8);

        var somma = 0;
        for(var linea : linee){
            var caratteri = linea.split("");
            var caratterePrimo = "";
            var carattereUltimo = "";
            var numero = 0;
            for (int i = 0; i < linea.length(); i++){
                try {

                    if (this.isDigit(caratteri[i])) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = caratteri[i];
                        } else {
                            carattereUltimo = caratteri[i];
                        }
                    } else if (caratteri[i].equals("o") && caratteri[i + 1].equals("n") && caratteri[i + 2].equals("e")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "1";
                        } else {
                            carattereUltimo = "1";
                        }
                    } else if (caratteri[i].equals("t") && caratteri[i + 1].equals("w") && caratteri[i + 2].equals("o")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "2";
                        } else {
                            carattereUltimo = "2";
                        }
                    } else if (caratteri[i].equals("t") && caratteri[i + 1].equals("h") && caratteri[i + 2].equals("r") && caratteri[i + 3].equals("e") && caratteri[i + 4].equals("e")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "3";
                        } else {
                            carattereUltimo = "3";
                        }
                    } else if (caratteri[i].equals("f") && caratteri[i + 1].equals("o") && caratteri[i + 2].equals("u") && caratteri[i + 3].equals("r")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "4";
                        } else {
                            carattereUltimo = "4";
                        }
                    } else if (caratteri[i].equals("f") && caratteri[i + 1].equals("i") && caratteri[i + 2].equals("v") && caratteri[i + 3].equals("e")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "5";
                        } else {
                            carattereUltimo = "5";
                        }
                    } else if (caratteri[i].equals("s") && caratteri[i + 1].equals("i") && caratteri[i + 2].equals("x")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "6";
                        } else {
                            carattereUltimo = "6";
                        }
                    } else if (caratteri[i].equals("s") && caratteri[i + 1].equals("e") && caratteri[i + 2].equals("v") && caratteri[i + 3].equals("e") && caratteri[i + 4].equals("n")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "7";
                        } else {
                            carattereUltimo = "7";
                        }
                    } else if (caratteri[i].equals("e") && caratteri[i + 1].equals("i") && caratteri[i + 2].equals("g") && caratteri[i + 3].equals("h") && caratteri[i + 4].equals("t")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "8";
                        } else {
                            carattereUltimo = "8";
                        }
                    } else if (caratteri[i].equals("n") && caratteri[i + 1].equals("i") && caratteri[i + 2].equals("n") && caratteri[i + 3].equals("e")) {
                        if (caratterePrimo.isBlank()) {
                            caratterePrimo = "9";
                        } else {
                            carattereUltimo = "9";
                        }
                    }
                }catch (Exception e){
                }

            }

            if (carattereUltimo.isBlank()){
                carattereUltimo = caratterePrimo;
            }
            numero = Integer.parseInt(caratterePrimo + carattereUltimo);
            somma += numero;

        }

        System.out.println(somma);

    }


    public boolean isDigit(String carattere){
        try {
            Integer.parseInt(carattere);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }


}
