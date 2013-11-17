/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.entidades;

import java.util.HashMap;

/**
 *
 * @author rafa
 */
public class AlmacenBean {
    private HashMap<productoBean,Integer> articulos = new HashMap();

    public HashMap<productoBean,Integer> getArticulos() {
        return articulos;
    }

    public void setArticulos(HashMap<productoBean,Integer> articulos) {
        this.articulos = articulos;
    }
    


    public void addArticulo(productoBean producto, Integer cantidad) {
        this.articulos.put(producto, cantidad);
    }
    public Integer getArticulo(productoBean producto) {
        return this.articulos.get(producto);
    }
}
