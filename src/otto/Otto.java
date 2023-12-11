package otto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Otto {
    private static final String FILE_NAME = "src/otto/otto.txt";

    public List<String> readLines() throws IOException {
        Path path = Path.of(FILE_NAME);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public HashMap<String, List<String>> indicazioni() throws IOException {
        var mappa = new HashMap<String, List<String>>();
        var linee = this.readLines();

        for (var i = 2; i < linee.size(); i++) {
            var chiave = linee.get(i).split(" = ")[0];
            var sinistra = linee.get(i).split(" = ")[1].replace("(", "").replace(")", "").split(", ")[0];
            var destra = linee.get(i).split(" = ")[1].replace("(", "").replace(")", "").split(", ")[1];

            var indicazioni = List.of(sinistra, destra);
            mappa.put(chiave, indicazioni);
        }

        return mappa;
    }

    public void gioco() throws IOException {


        var linee = this.readLines();
        var movimenti = linee.get(0).split("");
        var mappa = this.indicazioni();

        var contaMosse = 0;
        var passaggio = 0;

        var posizione = "AAA";
        while (!posizione.equals("ZZZ")) {
            var direzione = movimenti[passaggio];
            passaggio++;
            contaMosse++;

            if (direzione.equals("L")) {
                posizione = mappa.get(posizione).get(0);
            } else {
                posizione = mappa.get(posizione).get(1);
            }

            if (passaggio == movimenti.length) {
                passaggio = 0;
            }

        }
        System.out.println(contaMosse);
    }

    public void gioco2() throws IOException {
        var linee = this.readLines();
        var movimenti = linee.get(0).split("");
        var mappa = this.indicazioni();

        var passaggio = 0;
        var partente = new ArrayList<String>();

        for (var step : mappa.keySet()) {
            if (step.endsWith("A")) {
                partente.add(step);
            }
        }
        var listaContaMosse = new ArrayList<Long>();
        for (var partenza : partente) {
            var contaMosse = 0L;
            while (!partenza.endsWith("Z")) {
                var direzione = movimenti[passaggio];
                passaggio++;
                contaMosse++;

                if (direzione.equals("L")) {
                    partenza = mappa.get(partenza).get(0);
                } else {
                    partenza = mappa.get(partenza).get(1);
                }

                if (passaggio == movimenti.length) {
                    passaggio = 0;
                }
            }
            listaContaMosse.add(contaMosse);
        }

        System.out.println(lcm(listaContaMosse));


    }


    public static Long lcm(List<Long> numbers) {
        Long result = 1L;
        for (Long number : numbers) {
            result = lcm(result, number);
        }
        return result;
    }

    public static Long lcm(Long a, Long b) {
        return a * (b / gcd(a, b));
    }

    public static Long gcd(Long a, Long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

