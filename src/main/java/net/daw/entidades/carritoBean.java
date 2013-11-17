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
public class carritoBean {
        private HashMap<productoBean,Integer> carrito = new HashMap();

    public HashMap<productoBean,Integer> getArticulos() {
        return carrito;
    }

    public void setArticulos(HashMap<productoBean,Integer> articulos) {
        this.carrito = articulos;
    }
    


    public void addArticulo(productoBean producto, Integer cantidad) {
        this.carrito.put(producto, cantidad);
    }
    public Integer getArticulo(productoBean producto) {
        return this.carrito.get(producto);
    }
}
