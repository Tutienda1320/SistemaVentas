
package Funciones;

import Datos.Dventa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fdevolucion {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;
    
    public DefaultTableModel mostrar() {

        DefaultTableModel modelo;

        String[] titulos = {"Numero",
            "Fecha ", "Total", "COD USU",
            "Usuario", "COD CLIE", "Cliente", "Comprobante", "Numero", "Dscto"};

        String[] registros = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_venta , fecha_venta , Replace(Format(total_venta, 0), ',', '.') as total_venta  , cod_usuarioFK,"
                + "(select nombre_persona from persona where cod_persona = cod_usuarioFK)"
                + "as usuarioNom,cod_clienteFK ,"
                + "(select nombre_persona from persona where cod_persona = cod_clienteFK)"
                + "as clienteNom ,tipo_comprobante,num_factura,descuento from venta order by cod_venta DESC";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_venta");
                registros[1] = rs.getString("fecha_venta");
                registros[2] = rs.getString("total_venta");
                registros[3] = rs.getString("cod_usuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[5] = rs.getString("cod_clienteFK");
                registros[6] = rs.getString("clienteNom");
                registros[7] = rs.getString("tipo_comprobante");
                registros[8] = rs.getString("num_factura");
                registros[9] = rs.getString("descuento");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Dventa datos) {

        sSQL = "insert into venta "
                + "(fecha_venta,total_venta,cod_usuarioFK,cod_clienteFK,tipo_comprobante,num_factura,descuento,pago)"
                + "values(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setDate(1, datos.getFecha_venta());
            pst.setLong(2, datos.getTotal_venta());
            pst.setInt(3, datos.getCod_usuarioFK());
            pst.setInt(4, datos.getCod_clienteFK());
            pst.setString(5, datos.getTipo_comprobante());
            pst.setInt(6, datos.getNum_factura());
            pst.setInt(7, datos.getDescuento());
            pst.setLong(8, datos.getPago());
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

    public boolean editar(Dventa datos) {
        sSQL = "update venta set fecha_venta = ?, "
                + "total_venta = ? , cod_usuarioFK = ?  , cod_clienteFK = ? ,"
                + " tipo_comprobante =?,num_factura=? , descuento=? where cod_venta = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setDate(1, datos.getFecha_venta());
            pst.setLong(2, datos.getTotal_venta());
            pst.setInt(3, datos.getCod_usuarioFK());
            pst.setInt(4, datos.getCod_clienteFK());
            pst.setString(5, datos.getTipo_comprobante());
            pst.setInt(6, datos.getNum_factura());
            pst.setInt(7, datos.getDescuento());
            pst.setInt(8, datos.getCod_venta());

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

    public boolean eliminar(Dventa datos) {
        sSQL = "delete from venta where cod_venta = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getCod_venta());
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
}
