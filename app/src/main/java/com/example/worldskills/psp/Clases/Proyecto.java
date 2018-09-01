package com.example.worldskills.psp.Clases;

import java.io.Serializable;

public class Proyecto implements Serializable {
    private String nombreProyecto;

    public Proyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**

     * Metodo Par obtener el Nombre de Un proyecto
     * @return el Nombre del Proyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }
}
