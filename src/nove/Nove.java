package nove;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Nove {
    Integer somma = 0;
    private static final String FILE_NAME = "src/nove/nove.txt";

    public List<String> readLines() throws IOException {
        Path path = Path.of(FILE_NAME);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public Integer ricorsivo(List<Integer> subSerie){

        if (subSerie.stream().allMatch(e -> e.equals(0))){
            return 0;
        } else if (subSerie.stream().allMatch(e -> e.equals(subSerie.get(0)))){
            return subSerie.get(0);
        } else {
            var newSerie = new ArrayList<Integer>();

            for (var i = 1; i < subSerie.size(); i++){
                var diff = subSerie.get(i) - subSerie.get(i - 1);
                newSerie.add(diff);
            }

            var incremento = this.ricorsivo(newSerie);
            subSerie.add(subSerie.get(subSerie.size() - 1) + incremento);

            return subSerie.get(subSerie.size() - 1);
        }
    }

    public List<Integer> creaListe(String linea){
        var sNumeri = linea.split(" ");
        var lista = new ArrayList<Integer>();

        for (var numero : sNumeri){
            var n = Integer.parseInt(numero);
            lista.add(n);
        }

        return lista;
    }

    public void gioco() throws IOException {
        var linee = this.readLines();

        for (var linea : linee){
            var lista = this.creaListe(linea);
            var ultimoNumero = this.ricorsivo(lista);
            this.somma += ultimoNumero;
        }

        System.out.println(somma);
    }

    public Integer ricorsivoDifferenza(List<Integer> subSerie){
        if (subSerie.stream().allMatch(e -> e.equals(0))){
            return 0;
        } else if (subSerie.stream().allMatch(e -> e.equals(subSerie.get(0)))){
            return subSerie.get(0);
        }else {
            var newSerie = new ArrayList<Integer>();

            for (var i = 1; i < subSerie.size(); i++){
                var diff = subSerie.get(i) - subSerie.get(i - 1);
                newSerie.add(diff);
            }

            var decremento = this.ricorsivoDifferenza(newSerie);
            subSerie.add(0, subSerie.get(0) - decremento);

            return subSerie.get(0);
        }
    }

    public void gioco2() throws IOException {
        var linee = this.readLines();
        somma = 0;
        for (var linea : linee){
            var lista = this.creaListe(linea);
            var ultimoNumero = this.ricorsivoDifferenza(lista);
            this.somma += ultimoNumero;
        }

        System.out.println(somma);
    }
}
