/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapeo;

import static com.mycompany.mapeo.MetodoPrincipal.llenar;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniel
 * @author MateoG
 * @version 1.0
 */
public class MetodoPrincipalTest {
    
    public MetodoPrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Prueba unitaria para el metodo buscarPersona de la clase MetodoPrincipal
     */
    @Test
    public void testBuscarPersona() {
        HashMap<Integer, Persona> map = new HashMap<Integer, Persona>();
        map=llenar();
        System.out.println("buscarPersona");
        HashMap<Integer, Persona> map2 = map;
        String expResult = "nombre=cesar arevalo cedula=1070980393 HIJOS nombre=daniel arevalo cedula=1070980395 nombre=tomas arevalo cedula=1070980394 PADRE nombre=luis arevalo cedula=1070980392";
        String result = MetodoPrincipal.buscarPersona(map2);
        assertEquals(expResult, result);
    }
    
}
