/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Date;

/**
 *
 * @author angel
 */
public class myFile extends myArchive {

    Date fechaCreacion;
    int size;

    public myFile(String nombre, boolean x, boolean w, boolean r, Date fechaCreacion, int size) {
        super(nombre, x, w, r);
        this.fechaCreacion = fechaCreacion;
        this.size = size;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
