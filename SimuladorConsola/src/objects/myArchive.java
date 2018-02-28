/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author angel
 */
public class myArchive {

    String nombre;
    boolean x;
    boolean w;
    boolean r;

    public myArchive(String nombre, boolean x, boolean w, boolean r) {
        this.nombre = nombre;
        this.x = x;
        this.w = w;
        this.r = r;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isX() {
        return x;
    }

    public void setX(boolean x) {
        this.x = x;
    }

    public boolean isW() {
        return w;
    }

    public void setW(boolean w) {
        this.w = w;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

}
