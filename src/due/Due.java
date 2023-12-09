package due;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Due {

    public List<String> getLinee() throws IOException {
        var fileName = "src/due/due.txt";
        var path = Path.of(fileName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public void gioco2() throws IOException {
        var linee = this.getLinee();

        var somma = 0;

        for (var linea : linee){
            var minR = 0;
            var minB = 0;
            var minV = 0;

            var tentativi = linea.split(":")[1].split(";");

            for (var tentativo : tentativi){

                var pescaggi = tentativo.split(",");

                for (var pesc : pescaggi){

                    if (pesc.contains("red")){
                        pesc = pesc.replace("red", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > minR){
                            minR = val;
                        }
                    }

                    if (pesc.contains("green")){
                        pesc = pesc.replace("green", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > minV){
                            minV = val;
                        }
                    }

                    if (pesc.contains("blue")){
                        pesc = pesc.replace("blue", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > minB){
                            minB = val;
                        }
                    }
                }
            }

            var prod = minV * minR * minB;
            somma += prod;
        }

        System.out.println(somma);
    }





    public void gioco() throws IOException {
        var linee = this.getLinee();

        var maxR = 12;
        var maxV = 13;
        var maxB = 14;

        var somma = 0;

        for (var linea : linee){
            var game = linea.split(":")[0];
            var nGame = Integer.parseInt(game.split(" ")[1]);
            var bol = true;

            var tentativi = linea.split(":")[1].split(";");

            for (var tentativo : tentativi){

                var pescaggi = tentativo.split(",");

                for (var pesc : pescaggi){

                    if (pesc.contains("red")){
                        pesc = pesc.replace("red", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > maxR){
                            bol = false;
                        }
                    }

                    if (pesc.contains("green")){
                        pesc = pesc.replace("green", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > maxV){
                            bol = false;
                        }
                    }

                    if (pesc.contains("blue")){
                        pesc = pesc.replace("blue", "");
                        pesc = pesc.trim();
                        var val = Integer.parseInt(pesc);

                        if (val > maxB){
                            bol = false;
                        }
                    }
                }
            }

            if (bol){
                somma += nGame;
            }
        }

        System.out.println(somma);
    }
}
