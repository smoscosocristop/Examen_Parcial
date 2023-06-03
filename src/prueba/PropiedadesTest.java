/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import dominio.Propiedades;
import datos.impl.PropiedadesDaoImpl;

/**
 *
 * @author ALUMNO
 */
public class PropiedadesTest {
    public static void main(String[] args) {
        

        insertarPropiedades("Casa");
        insertarPropiedades("Edificio");
        insertarPropiedades("Departamento");

        
    }

    private static void insertarPropiedades(String nombre) {

        Propiedades obj = new Propiedades();
        PropiedadesDaoImpl datos = new PropiedadesDaoImpl();
        obj.setNombre(nombre);
        boolean resp;
        resp = datos.insertar(obj);
        System.out.println("Insertado" + resp);
    }

}
