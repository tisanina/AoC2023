package sette;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sette {
    private static final String FILE_NAME = "src/sette/sette.txt";

    public List<String> readLines() throws IOException {
        Path path = Path.of(FILE_NAME);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public void game() throws IOException {
        List<String> lines = this.readLines();
        List<Puntata> bets = createBetsFromLines(lines);
        bets.sort(null);
        int sum = calculateSum(bets);
        System.out.println(sum);
    }

    private List<Puntata> createBetsFromLines(List<String> lines) {
        List<Puntata> bets = new ArrayList<>();
        for (String line : lines){
            Puntata bet = createPuntataFromLine(line);
            bets.add(bet);
        }
        return bets;
    }

    private Puntata createPuntataFromLine(String line) {
        String[] parts = line.split(" ");
        Puntata bet = new Puntata(parts[0], parts[1]);
        bet.setTipo();
        return bet;
    }

    private int calculateSum(List<Puntata> bets) {
        int sum = 0;
        for (int i = 0; i < bets.size(); i++){
            int points = Integer.parseInt(bets.get(i).getQuota()) * (i + 1);
            sum += points;
        }
        return sum;
    }

    public void gioco2() throws IOException {
        var linee = this.readLines();

        var lista = new ArrayList<PuntataJ>();
        for (var linea : linee){
            var puntata = new PuntataJ(linea.split(" ")[0], linea.split(" ")[1]);
            puntata.setTipo();
            lista.add(puntata);
        }

        Collections.sort(lista);
        var somma = 0;
        for (var i = 0; i < lista.size(); i++){
            var punti = Integer.parseInt(lista.get(i).getQuota()) * (i + 1);
            somma += punti;
        }

        System.out.println(somma);
    }
}
