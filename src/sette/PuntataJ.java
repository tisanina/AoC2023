package sette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuntataJ implements Comparable<PuntataJ>{
    public static final Map<String, Integer> VALORI_CARTE = new HashMap<>();
    public static final String[] maniVincenti = {"cartaAlta", "coppia", "doppiaCoppia", "tris", "full", "poker", "penta"};
    static {
        VALORI_CARTE.put("J", 0);
        VALORI_CARTE.put("2", 1);
        VALORI_CARTE.put("3", 2);
        VALORI_CARTE.put("4", 3);
        VALORI_CARTE.put("5", 4);
        VALORI_CARTE.put("6", 5);
        VALORI_CARTE.put("7", 6);
        VALORI_CARTE.put("8", 7);
        VALORI_CARTE.put("9", 8);
        VALORI_CARTE.put("T", 9);
        VALORI_CARTE.put("Q", 10);
        VALORI_CARTE.put("K", 11);
        VALORI_CARTE.put("A", 12);


    }

    private String mano;
    private String quota;
    private Integer tipoMano = 0;

    public PuntataJ(String mano, String quota) {
        this.mano = mano;
        this.quota = quota;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    @Override
    public int compareTo(PuntataJ o) {
        if (this.tipoMano > o.getTipoMano()){
            return 1;
        } else if (this.tipoMano < o.getTipoMano()) {
            return -1;
        } else {
            for (int i = 0; i< this.mano.length(); i++){
                var carThis = this.mano.split("")[i];
                var carO = o.getMano().split("")[i];

                if (carThis.equals(carO)){
                    continue;
                } else if (VALORI_CARTE.get(carThis) > VALORI_CARTE.get(carO)) {
                    return 1;
                } else {
                    return -1;
                }


            }
        }
        return 0;
    }

    public Integer getTipoMano() {
        return tipoMano;
    }

    public void setTipoMano(Integer tipoMano) {
        this.tipoMano = tipoMano;
    }

    public void setTipo(){

        var mappa = countOccurrences(this.mano);
        if (mappa.containsValue(5)){
            this.tipoMano = 6;
        } else if (mappa.containsValue(4)) {
            this.tipoMano = 5;
        }
        else if (mappa.containsValue(3) && mappa.containsValue(2)) {
            this.tipoMano = 4;
        }
        else if (mappa.containsValue(2)) {
            this.tipoMano = 3;
        }
        else if (doesValueAppearTwice(mappa, 2)) {
            this.tipoMano = 2;
        }
        else if (mappa.containsValue(2)) {
            this.tipoMano = 1;
        }
        else {
            this.tipoMano = 0;
        }



    }

    public static boolean doesValueAppearTwice(Map<Character, Integer> map, int value) {
        List<Integer> values = new ArrayList<>(map.values());
        int frequency = Collections.frequency(values, value);
        return frequency == 2;
    }


    public static Map<Character, Integer> countOccurrences(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Trova la lettera più frequente
        Character mostFrequent = null;
        for (Character c : counts.keySet()) {
            if (mostFrequent == null || counts.get(c) > counts.get(mostFrequent)) {
                mostFrequent = c;
            }
        }

        // Aggiungi le occorrenze di 'J' alla lettera più frequente, se esiste
        if (counts.containsKey('J') && mostFrequent != null) {
            counts.put(mostFrequent, counts.get(mostFrequent) + counts.get('J'));
            counts.remove('J');
        }

        return counts;
    }
}
