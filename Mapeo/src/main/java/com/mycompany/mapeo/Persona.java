/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapeo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author daniel
 * @author MateoG
 * @version 1.0
 */
public class Persona {
    /**
     * Variable para guardar la cedula de la persona
     */   
    Integer cedula;
    /**
     * Variable para guardar el nombre de la persona
     */
    String nombre;
    /**
     * Hashmap para guardar los hijos de la persona
     */
    HashMap<Integer, Persona> hijos;
    /**
     * Constructor con cedula y nombre
     * @param cedula recibe el numero de cedula de la persona
     * @param nombre recibe el nombre de la persona
     */   
    public Persona(Integer cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    /**
     * Método para mostrar los hijos de la persona
     * @return devuelve una variable tipo String con los hijos de la persona
     */   
    public String mostrarHijos(){
        String salida = "";
        if(hijos.values().isEmpty()){
            //System.out.println("sin hijos");
            salida = " SIN HIJOS";
        }else{
            //System.out.println("hijos");
            salida = " HIJOS";
            for(Map.Entry <Integer, Persona> entry: hijos.entrySet()){
            //System.out.println(entry.getValue().getNombre());
            salida = salida+" nombre="+entry.getValue().getNombre();
            //System.out.println(entry.getValue().getCedula());
            salida = salida+" cedula="+entry.getValue().getCedula();
            }
        }
        return salida;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHijos(HashMap<Integer, Persona> hijos) {
        this.hijos = hijos;
    }

    public Integer getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Persona> getHijos() {
        return hijos;
    }
}
