package negocio;

import datos.PropiedadesDao;
import datos.impl.PropiedadesDaoImpl;
import dominio.Propiedades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class PropiedadesControl {
    private final PropiedadesDao DATOS;
    private Propiedades obj;

    public PropiedadesControl() {
       this.DATOS = new PropiedadesDaoImpl();
       this.obj = new Propiedades();
    }
    
    private DefaultTableModel modeloTabla;
    public DefaultTableModel listar(String texto){
        
        List<Propiedades> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "NOMBRE", "DIRECION", "CARACTERSITICAS", "ESTADO", "PRECIO DE ALQUILER"};
        String[] registro = new String[6];
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        for (Propiedades item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDireccion();
            registro[3] = item.getCaracteristicas();
            registro[4] = item.getEstado();
            registro[5] = Double.toString(item.getPrecioalquiler());


            this.modeloTabla.addRow(registro);
        }
            return this.modeloTabla;
        }
    
    public String insertar(Propiedades obj) {
        if (DATOS.insertar(obj)) {
        return "OK";
        } else {
        return "Error en el ingreso de datos.";
        }
    }
    
    public String actualizar(Propiedades obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización de datos.";
        }
        }
    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK";
        } else {
            return "Error en la eliminación de datos.";
        }
    }

}
