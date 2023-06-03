/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import datos.PropiedadesDao;
import dominio.Propiedades;
import datos.impl.PropiedadesDaoImpl;

/**
 *
 * @author ALUMNO
 */
public class PropiedadesTest {
    
    /*public static void main(String[] args) {
    PropiedadesDao datos = new PropiedadesDaoImpl();
    System.out.println(datos.listar("").size());
    System.out.println(datos.listar("").get(0));
 }*/
//    public static void main(String[] args) {
//        
//
//        //insertarPropiedades("Edificio", "direj", "carej", "estej", 200);
//        insertarPropiedades("Departamento", "direj2", "carej2", "estej2", 2000);
//
//        
//    }
//
//    private static void insertarPropiedades(String nombre, String direccion, String caracteristicas, String estado, double precioalquiler) {
//
//        Propiedades obj = new Propiedades();
//        PropiedadesDaoImpl datos = new PropiedadesDaoImpl();
//        
//        obj.setNombre(nombre);
//        obj.setDireccion(direccion);
//        obj.setCaracteristicas(caracteristicas);
//        obj.setEstado(estado);
//        obj.setPrecioalquiler(precioalquiler);
//
//
//        boolean resp;
//        resp = datos.insertar(obj);
//        System.out.println("Insertado " + resp);
//    }
    
    /*public static void main(String[] args) {
        PropiedadesDao datos = new PropiedadesDaoImpl();
        Propiedades obj=new Propiedades();
        obj.setId(3);
        
        obj.setNombre("casa 3");
        obj.setDireccion("direj3");
        obj.setCaracteristicas("carej3");
        obj.setEstado("estej3");
        obj.setPrecioalquiler(300);

        System.out.println(datos.actualizar(obj));
    }*/

    public static void main(String[] args) {
        PropiedadesDao datos = new PropiedadesDaoImpl();
        System.out.println(datos.eliminar(5));
    }
}
