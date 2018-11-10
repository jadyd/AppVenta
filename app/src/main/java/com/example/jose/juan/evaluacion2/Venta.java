package com.example.jose.juan.evaluacion2;

import java.io.Serializable;
import java.util.ArrayList;

public class Venta implements Serializable {
    private int idVenta;
    private Cliente cliente;
    private ArrayList<Producto> detalle;

    public Venta() {

    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Producto> detalle) {
        this.detalle = detalle;
    }
}
