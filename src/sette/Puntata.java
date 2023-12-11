package sette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Puntata implements Comparable<Puntata> {
    public static final Map<String, Integer> VALORI_CARTE = new HashMap<>();
    public static final String[] maniVincenti = {"cartaAlta", "coppia", "doppiaCoppia", "tris", "full", "poker", "penta"};
    static {
        VALORI_CARTE.put("2", 1);
        VALORI_CARTE.put("3", 2);
        VALORI_CARTE.put("4", 3);
        VALORI_CARTE.put("5", 4);
        VALORI_CARTE.put("6", 5);
        VALORI_CARTE.put("7", 6);
        VALORI_CARTE.put("8", 7);
        VALORI_CARTE.put("9", 8);
        VALORI_CARTE.put("T", 9);
        VALORI_CARTE.put("J", 10);
        VALORI_CARTE.put("Q", 11);
        VALORI_CARTE.put("K", 12);
        VALORI_CARTE.put("A", 13);


    }

    private String mano;
    private String quota;
    private Integer tipoMano;

    public Puntata(String mano, String quota) {
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
    public int compareTo(Puntata o) {
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
        var carte = this.mano.split("");
        var carteCensite = new ArrayList<String>();

        for (var i = 0; i < carte.length; i++){
            var c = carte[i];
            var y = i;
            var copie = Arrays.stream(carte).filter(a -> a.equals(c)).toList();
            if (copie.size() == 5){
                this.tipoMano = 6;
            }
            if (copie.size() == 4){
                this.tipoMano = 5;
            }
            if (copie.size() == 3){
                if (!carteCensite.contains(carte[y])){
                    if (this.tipoMano == null || this.tipoMano == 0){
                        this.tipoMano = 3;
                        carteCensite.add(carte[y]);
                    }
                    else {
                        this.tipoMano = 4;
                    }
                }
            }
            if (copie.size() == 2){
                if (!carteCensite.contains(carte[y])){
                    if (this.tipoMano == null || this.tipoMano == 0){
                        this.tipoMano = 1;
                        carteCensite.add(carte[y]);
                    }
                    else {
                        if (tipoMano == 1){
                            this.tipoMano = 2;
                        }
                        if (tipoMano == 3){
                            this.tipoMano = 4;
                        }
                    }
                }

            }
            else {
                if (this.tipoMano == null) {
                    this.tipoMano = 0;
                }
            }
        }
    }
}
