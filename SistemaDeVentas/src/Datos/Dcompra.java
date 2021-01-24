 
package Datos;
 
import java.sql.Date;

public class Dcompra {

    private int cod_comp;
    private int cod_prov ;
    private String numfactura_comp ;
    private Date fecha_comp;
    private int total_comp;
    
    public Dcompra() {
       
    }

    public Dcompra(int cod_comp, int cod_prov, String numfactura_comp, Date fecha_comp, int total_comp) {
        this.cod_comp = cod_comp;
        this.cod_prov = cod_prov;
        this.numfactura_comp = numfactura_comp;
        this.fecha_comp = fecha_comp;
        this.total_comp = total_comp;
    }

    public int getcod_comp() {
        return cod_comp;
    }

    public void setcod_comp(int cod_comp) {
        this.cod_comp = cod_comp;
    }

    public int getcod_prov() {
        return cod_prov;
    }

    public void setcod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
    }
  
    public String getnumfactura_comp() {
        return numfactura_comp;
    }

    public void setnumfactura_comp(String numfactura_comp) {
        this.numfactura_comp = numfactura_comp;
    }

    public Date getfecha_comp() {
        return fecha_comp;
    }

    public void setfecha_comp(Date fecha_comp) {
        this.fecha_comp = fecha_comp;
    }

    public int gettotal_comp() {
        return total_comp;
    }

    public void settotal_comp(int total_comp) {
        this.total_comp = total_comp;
    }    
}
