package Funciones;

import Datos.Dproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fproducto {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", "Unidad  ",
                    "Precio Venta", "Stock",
                     "Ubicacion Bodega","Categoria"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_producto , nombre_producto , descripcion_producto , unidad_producto, Replace(Format(precio_producto, 0), ',', '.') as precio_producto , stock_producto , ubicacion_bodega,(select nombre_categoria from categoria where  cod_categoria =cod_categoriaFK) as nombre_categoria "
                + "from producto "
                + "where nombre_producto like '%" + buscar + "%' order by cod_producto desc";

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
                registros[6] = rs.getString("ubicacion_bodega");
                registros[7] = rs.getString("nombre_categoria");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    public String consultarNombe(int buscar) {
        String nombre = "";

        sSQL = "select nombre_producto "
                + "from producto "
                + "where cod_producto =" + buscar + "";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                nombre = rs.getString("nombre_producto");
            }
            return nombre;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dproducto datos,String nombre) {

        sSQL = "insert into producto (cod_producto , nombre_producto,descripcion_producto"
                + ", unidad_producto , precio_producto,stock_producto,ubicacion_bodega,cod_categoriaFK)"
                + " values (?,?,?,?,?,?,?,"
                + "(select cod_categoria from categoria where nombre_categoria like '%" + nombre + "%'))";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, datos.getCod_producto());
            pst.setString(2, datos.getNombre_producto());
            pst.setString(3, datos.getDescripcion_producto());
            pst.setString(4, datos.getUnidad_producto());
            pst.setLong(5, datos.getPrecio_producto());
            pst.setInt(6, datos.getStock_producto());
            pst.setString(7, datos.getUbicacion_bodega());
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

    public boolean editar(Dproducto datos, String nombre) {

        sSQL = "update producto set nombre_producto = ? , descripcion_producto = ?  , unidad_producto = ? , precio_producto = ? , stock_producto = ? , ubicacion_bodega = ? , cod_categoriaFK =(select cod_categoria from categoria where nombre_categoria like '%" + nombre + "%' limit 1)   where cod_producto =? ";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getNombre_producto());
            pst.setString(2, datos.getDescripcion_producto());
            pst.setString(3, datos.getUnidad_producto());
            pst.setLong(4, datos.getPrecio_producto());
            pst.setInt(5, datos.getStock_producto());

            pst.setString(6, datos.getUbicacion_bodega());

            pst.setLong(7, datos.getCod_producto());

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

        sSQL = "update producto set stock_producto = ? , ubicacion_bodega = ?  where cod_producto = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getStock_producto());
            pst.setString(2, datos.getUbicacion_bodega());            
            pst.setLong(3, datos.getCod_producto());

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
                    "Precio Venta", "Stock", "Ubicacion Bodega"};

        String[] registros = new String[7];
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

                registros[6] = rs.getString("ubicacion_bodega");

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

        sSQL = "SELECT cod_prov from proveedores where cod_prov = " + codigo;

        try {
            int cod = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getInt("cod_prov");
            }

            return cod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
    
    public int consultarStockPorProducto(int codigo) {

        sSQL = "SELECT stock_producto from producto where cod_producto = " + codigo;

        try {
            int Stock = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                Stock = rs.getInt("stock_producto");
            }
            return Stock;
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
                    "Precio Venta", "Stock", "ubicacion bodega"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_producto , nombre_producto , descripcion_producto , unidad_producto, precio_producto , stock_producto ,ubicacion_bodega from producto where nombre_producto like '%" + buscar + "%' order by cod_producto desc";

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
                registros[6] = rs.getString("ubicacion_bodega");

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
