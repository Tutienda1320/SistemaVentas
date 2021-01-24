package Funciones;

import Datos.Dproducto;
import Datos.Dproveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fproveedor {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Direccion", "telefono",
                    "NIT / CC"};

        String[] registros = new String[9];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * "
                + "from proveedores "
                + "where nombre_prov like '%" + buscar + "%' order by nombre_prov desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_prov");
                registros[1] = rs.getString("nombre_prov");
                registros[2] = rs.getString("direccion_prov");
                registros[3] = rs.getString("telefono_prov");
                registros[4] = rs.getString("nit_prov");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Dproveedor datos) {

        sSQL = "insert into proveedores (nombre_prov,direccion_prov,telefono_prov,nit_prov )"
                + " values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getnombre_prov());
            pst.setString(2, datos.getdireccion_prov());
            pst.setString(3, datos.gettelefono_prov());
            pst.setString(4, datos.getnit_prov());
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

    public boolean editar(Dproveedor datos) {

        sSQL = "update proveedores set nombre_prov = ? , direccion_prov = ?  , telefono_prov = ? , nit_prov = ? where cod_prov =? ";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getnombre_prov());
            pst.setString(2, datos.getdireccion_prov());
            pst.setString(3, datos.gettelefono_prov());
            pst.setString(4, datos.getnit_prov());
            pst.setInt(5, datos.getcod_prov());

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

    public boolean eliminar(Dproducto datos) {
        sSQL = "delete from producto where cod_producto = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, datos.getCod_producto());
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

    /**
     * ***** FUNCION STOCK ****
     */
    public boolean ModificarStockProductos(Dproducto datos) {

        sSQL = "update producto set stock_producto = ? where cod_producto = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getStock_producto());

            pst.setLong(2, datos.getCod_producto());

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

    }

    public DefaultTableModel mostrarPorCodigo(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", "Unidad  ",
                    "Precio Venta", "Stock", "Precio Compra", "Bodega"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from producto where cod_producto =" + buscar + " order by cod_producto desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("unidad_producto");
                registros[4] = rs.getString("precio_producto");
                registros[5] = rs.getString("stock_producto");
                registros[6] = rs.getString("precio_compra");

                registros[7] = rs.getString("ubicacion_bodega");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public int productoIgual(int codigo) {

        sSQL = "SELECT cod_producto from producto where cod_producto = " + codigo;

        try {
            int cod = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getInt("cod_producto");
            }

            return cod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }

    public DefaultTableModel mostrarExportar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", "Unidad  ",
                    "Precio Venta", "Stock", "Precio Compra,ubicacion bodega"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_producto , nombre_producto , descripcion_producto , unidad_producto, precio_producto , stock_producto ,  precio_compra ,ubicacion_bodega from producto where nombre_producto like '%" + buscar + "%' order by cod_producto desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("unidad_producto");
                registros[4] = rs.getString("precio_producto");
                registros[5] = rs.getString("stock_producto");
                registros[6] = rs.getString("precio_compra");
                registros[7] = rs.getString("ubicacion_bodega");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "select nombre_categoria from categoria";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("nombre_categoria"));
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

}
