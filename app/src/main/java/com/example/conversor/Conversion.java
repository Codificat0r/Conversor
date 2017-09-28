package com.example.conversor;

public class Conversion {

    private double cambio = 1.18;

    public Conversion() {

    }

    public String convertirADolares (String cantidad) {
        return Double.toString(Double.parseDouble(cantidad) / cambio);
    }

    public String convertirAEuros (String cantidad) {
        return Double.toString(Double.parseDouble(cantidad) * cambio);
    }
}
