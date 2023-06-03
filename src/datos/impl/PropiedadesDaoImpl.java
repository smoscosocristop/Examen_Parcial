
package datos.impl;

import database.Conexion;
import datos.PropiedadesDao;
import dominio.Propiedades;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropiedadesDaoImpl implements PropiedadesDao<Propiedades>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public PropiedadesDaoImpl() {
    CON = Conexion.getInstancia();
    }
 @Override
    public List<Propiedades> listar(String texto) {
       List<Propiedades> registros = new ArrayList();
       try {
       ps = CON.conectar().prepareStatement("Select * from Propiedades where nombre like?");
       ps.setString(1, "%" + texto + "%");
       rs = ps.executeQuery();
       while (rs.next()) {

            registros.add(new Propiedades(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            //registros.add(new Propiedades(1, texto, texto, texto, texto, 0));
       }
       ps.close();
       rs.close();
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       } finally {
       ps = null;
       CON.desconectar();
       }
    return registros;
    }
 
    @Override
    public boolean insertar(Propiedades obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO Propiedades (nombre, direccion, caracteristicas, estado, precioalquiler ) VALUES(?,?,?,?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getCaracteristicas());
            ps.setString(4, obj.getEstado());
            ps.setDouble(5, obj.getPrecioalquiler());

            if (ps.executeUpdate() > 0) {
            resp = true;
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
            return resp;
    }

    @Override
    public boolean actualizar(Propiedades obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE Propiedades SET nombre=?, direccion=?, caracteristicas=?, estado=?, precioalquiler=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getCaracteristicas());
            ps.setString(4, obj.getEstado());
            ps.setDouble(5, obj.getPrecioalquiler());
            ps.setInt(6,obj.getId());

            if(ps.executeUpdate()>0){
                resp=true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            ps=null;
            CON.desconectar(); 
        }
            return resp;

    }

    @Override
    public boolean eliminar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("DELETE FROM Propiedades WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
            resp = true;
        }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }
}   
