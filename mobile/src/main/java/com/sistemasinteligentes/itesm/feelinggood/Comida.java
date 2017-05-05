package com.sistemasinteligentes.itesm.feelinggood;

/**
 * Created by t-dasalm on 5/1/2017.
 */

public class Comida {

    private String name;
    private int hora_inicio;
    private int min_inicio;
    private int hora_fin;
    private int min_fin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getMin_inicio() {
        return min_inicio;
    }

    public void setMin_inicio(int min_inicio) {
        this.min_inicio = min_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getMin_fin() {
        return min_fin;
    }

    public void setMin_fin(int min_fin) {
        this.min_fin = min_fin;
    }

}
