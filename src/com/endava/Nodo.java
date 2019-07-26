package com.endava;

import java.util.Objects;

public class Nodo {
    int noNodo;
    String nombreNodo;
    String tipoNodo;

    public Nodo(int noNodo, String nombreNodo, String tipoNodo) {
        this.noNodo = noNodo;
        this.nombreNodo = nombreNodo;
        this.tipoNodo = tipoNodo;
    }

    public int getNoNodo() {
        return noNodo;
    }

    public void setNoNodo(int noNodo) {
        this.noNodo = noNodo;
    }

    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    public String getTipoNodo() {
        return tipoNodo;
    }

    public void setTipoNodo(String tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return getNoNodo() == nodo.getNoNodo() &&
                getNombreNodo().equals(nodo.getNombreNodo()) &&
                getTipoNodo().equals(nodo.getTipoNodo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoNodo(), getNombreNodo(), getTipoNodo());
    }
}
