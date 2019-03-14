/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapeo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class MetodoPrincipal {
    
    public static HashMap<Integer, Persona> llenar(){
        HashMap<Integer, Persona> map1 = new HashMap<Integer, Persona>();
        HashMap<Integer, Persona> map2 = new HashMap<Integer, Persona>();
        HashMap<Integer, Persona> map = new HashMap<Integer, Persona>();
        HashMap<Integer, Persona> ma1 = new HashMap<Integer, Persona>();
        HashMap<Integer, Persona> ma2 = new HashMap<Integer, Persona>();
        Persona abuelo=new Persona(1070980392,"luis arevalo");
        Persona padre=new Persona(1070980393,"cesar arevalo");
        Persona hijo=new Persona(1070980394,"tomas arevalo");
        Persona hijo1=new Persona(1070980395,"daniel arevalo");
        Persona abuelo2=new Persona(1080980392,"agubusto Garnica");
        Persona padre2=new Persona(1080980393,"santiago Garnica");
        Persona hijo2=new Persona(1080980394,"Mateo Garnica");
        Persona hijo3=new Persona(1080980395,"evelyn Garnica");
        ma1.put(1080980394, hijo2);
        ma1.put(1080980395, hijo3);
        ma2.put(1080980393, padre2);
        map1.put(1070980395, hijo1);
        map1.put(1070980394, hijo);
        map2.put(1070980393, padre);
        padre.setHijos(map1);
        abuelo.setHijos(map2);
        padre2.setHijos(ma1);
        abuelo.setHijos(map2);
        abuelo2.setHijos(ma2);
        map.put(1070980392,abuelo);
        map.put(1080980392,abuelo2);
        return map;
    }
    public static HashMap<Integer, Persona> ingresar(HashMap<Integer, Persona> map){
        Integer cedula;
        String entradaTexto;
        System.out.println ("Ingrese el numero de cedula");
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTexto=entradaEscaner.nextLine ();
        try{
            cedula =Integer.parseInt(entradaTexto);
            System.out.println ("Ingrese el nombre");
        entradaTexto=entradaEscaner.nextLine ();
        Persona persona = new Persona(cedula,entradaTexto);
        map.put(cedula, persona);
        
        }catch(Exception e){
            System.out.println ("Ingreso erroneo");
        }
         
        return map;
    }
    public static void menu(){
        HashMap<Integer, Persona> map = new HashMap<Integer, Persona>();
        String entradaTexto;
        map=llenar();
        while(1==1){            
            System.out.println ("Ingrese 'v' para ver las paresonas ingrese 'i' para ingresar otro usuario ingrese 'b' para buscar");
            Scanner entradaEscaner = new Scanner (System.in);
            entradaTexto=entradaEscaner.nextLine ();
            switch (entradaTexto) {
                case "i":
                    map=ingresar(map);
                    break;
                case "v":
                    for (Map.Entry <Integer, Persona> entry: map.entrySet()) {
                        System.out.println("clave=" + entry.getKey() + ", nombre:" + entry.getValue().getNombre()+"\n");
                        map.get(1070980392).mostrarHijos();
                        //entry.getValue().mostrarPadres();
                    }
                    break;
                case "b":
                    buscar(map);
                    break;
                default:
                    System.out.println ("Opcion no valida.");
                    break;
                              
            }            
        }
    }
    public static void buscar(HashMap<Integer, Persona> map){
        String entradaTexto;
        Integer clave;
        Persona padre;
        int id=0;
        System.out.println ("Ingrese cedula");
        Scanner entradaEscaner = new Scanner (System.in);
        try{
            entradaTexto=entradaEscaner.nextLine ();
            clave=Integer.parseInt(entradaTexto); 
            for(Map.Entry <Integer, Persona> entry: map.entrySet()){
            //System.out.println(map.get(clave).getCedula());
            if(clave.equals(entry.getValue().getCedula())){
                System.out.println(map.get(clave).getCedula());
                id=1;               
                System.out.println("clave=" + map.get(clave).getCedula() + ", nombre:" + map.get(clave).getNombre()+"\n");
                map.get(clave).mostrarHijos();
            }
            }
            if(id==0){                    
                for(Persona persona:map.values()){ 
                    
                    for(int i=0; i<persona.getHijos().size();i++ ){  
                        padre=persona;
                        if(persona.getHijos().containsKey(clave)){
                            id=1;
                            System.out.println(id);
                            System.out.println("clave=" + persona.getHijos().get(clave).getCedula() + ", nombre:" + persona.getHijos().get(clave).getNombre()+"\n");
                            persona.getHijos().get(clave).mostrarHijos();
                            System.out.println("padre"+padre.getCedula()+" "+padre.getNombre());
                        }
                    }
                }                
            }
            if(id==0){
                for(Persona persona:map.values()){                    
                    for(int i=0; i<persona.getHijos().size();i++ ){
                        for(Persona persona1:persona.hijos.values()){
                            padre=persona1;
                            if(persona1.getHijos().containsKey(clave)){
                                id=1;
                                System.out.println("clave=" + persona1.getHijos().get(clave).getCedula() + ", nombre:" + persona1.getHijos().get(clave).getNombre()+"\n");
                                System.out.println("padre"+padre.getCedula()+" "+padre.getNombre());
                                persona1.getHijos().get(clave).mostrarHijos();
                            }
                        }                        
                    }
                }
            }
            if(id==0){
                System.out.println("persona no registrada");
            }
        
        }catch(Exception e){
            System.out.println("busqueda terminada");
        }                                        
    }
}
