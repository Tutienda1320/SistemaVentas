package Funciones;

import Controlador.FrmComprasDetalle;
import Controlador.FrmVentaDetalle;
import Datos.Ddetalle_compra;
import Datos.Ddetalle_venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fdetalle_compra {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String cod_comp) {

        DefaultTableModel modelo;
            String[] titulos
                = {"CODIGO ","NOMBRE ","CANTIDAD","PEROCIO UNI", "TOTAL"};
            
        String[] registros = new String[5];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT cod_productoFK," +
                "p.nombre_producto," +
                "catidad_deta_comp," +
                "Replace(Format(preciouni_deta_comp, 0), ',', '.') as preciouni_deta_comp," +
                "Replace(Format(preciototal_deta_comp, 0), ',', '.') as preciototal_deta_comp " +
                "from detalle_compra dc " +
                "inner join producto p on dc.cod_productoFK = p.cod_producto " +
                "WHERE cod_comp = '" + cod_comp + "' ORDER BY cod_comp ASC";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_productoFK");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("catidad_deta_comp");
                registros[3] = rs.getString("preciouni_deta_comp");
                registros[4] = rs.getString("preciototal_deta_comp");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(List<Ddetalle_compra> datos) {        
        int N = 0;
        try {
            for(Ddetalle_compra d:datos)
            {
                sSQL = "insert into detalle_compra (cod_comp , cod_productoFK,bodega_deta_comp,catidad_deta_comp"
                + ", preciouni_deta_comp ,preciototal_deta_comp) values (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(1, d.getcod_comp());
                pst.setInt(2, d.getCod_productoFK());
                pst.setString(3, d.getbodega_deta_comp());
                pst.setInt(4, d.getcatidad_deta_comp());
                pst.setInt(5, d.getpreciouni_deta_comp());
                pst.setInt(6, d.getpreciototal_deta_comp());   
                N= N+pst.executeUpdate();
            }
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

    public boolean eliminar(Ddetalle_compra datos) {

        sSQL = "delete from detalle_venta where cod_detalle = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, datos.getcod_deta_comp());
            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

    public long selecProd() {
        long codigo = Long.parseLong(FrmComprasDetalle.txtCod_producto.getText());
        sSQL = "SELECT cod_producto FROM producto WHERE cod_producto = " + codigo;
        try {
            long cod = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getLong("cod_producto");
            }
            return cod;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion */

    public String SelectNombre() {
        long codigo = Long.parseLong(FrmVentaDetalle.txtCod_producto.getText());
        sSQL = "SELECT nombre_producto FROM producto WHERE cod_producto = " + codigo;
        try {
            String nombre = "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                nombre = rs.getString("nombre_producto");
            }
            return nombre;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }//cierre funcion */

    public int selecStock() {
        long codigo = Long.parseLong(FrmVentaDetalle.txtCod_producto.getText());
        sSQL = "SELECT stock_producto FROM producto WHERE cod_producto = " + codigo;
        try {
            int stock = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                stock = rs.getInt("stock_producto");
            }
            return stock;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion */

    public long selectPrecio() {
        long codigo = Long.parseLong(FrmVentaDetalle.txtCod_producto.getText());
        sSQL = "SELECT precio_producto FROM producto WHERE cod_producto = " + codigo;
        try {
            long precio_producto = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                precio_producto = rs.getLong("precio_producto");
            }
            return precio_producto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion

    public long selectPrecioCompra() {
        long codigo = Long.parseLong(FrmVentaDetalle.txtCod_producto.getText());
        sSQL = "SELECT precio_compra FROM producto WHERE cod_producto = " + codigo;
        try {
            long precio_productoCompra = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                precio_productoCompra = rs.getLong("precio_compra");
            }
            return precio_productoCompra;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion

    public boolean insertarDetalle(Ddetalle_venta datos) {

        sSQL = "INSERT INTO detalle_venta (cantidad_detalle , cod_productoFK,precio_producto,"
                + "cod_ventaFk ,subtotal,subPrecioCompra,precio_compra) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, datos.getCantidad_detalle());
            pst.setLong(2, datos.getCod_productoFK());
            pst.setLong(3, datos.getPrecio_producto());
            pst.setInt(4, datos.getCod_ventaFK());
            pst.setLong(5, datos.getSubtotal());
            pst.setLong(6, datos.getSubPrecioCompra());
            pst.setLong(7, datos.getPrecio_compra());
            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El codigo ingresado no esta en el sistema");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

}
