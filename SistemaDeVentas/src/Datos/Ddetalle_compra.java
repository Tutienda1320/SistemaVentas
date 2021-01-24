
package Datos;




public class Ddetalle_compra {

    private int cod_deta_comp;
    private int cod_comp;
    private int cod_productoFK ;
    private String bodega_deta_comp ;
    private int catidad_deta_comp; 
    private int preciouni_deta_comp;
    private int preciototal_deta_comp;

    public Ddetalle_compra() {
    }

    public Ddetalle_compra(int cod_deta_comp, int cod_comp, int cod_productoFK, String bodega_deta_comp, int catidad_deta_comp, int preciouni_deta_comp, int preciototal_deta_comp) {
        this.cod_deta_comp = cod_deta_comp;
        this.cod_comp = cod_comp;
        this.cod_productoFK = cod_productoFK;
        this.bodega_deta_comp = bodega_deta_comp;
        this.catidad_deta_comp = catidad_deta_comp;
        this.preciouni_deta_comp = preciouni_deta_comp;
        this.preciototal_deta_comp = preciototal_deta_comp;
    }

 

    public int getcod_deta_comp() {
        return cod_deta_comp;
    }

    public void setcod_deta_comp(int cod_deta_comp) {
        this.cod_deta_comp = cod_deta_comp;
    }

    public int getcod_comp() {
        return cod_comp;
    }

    public void setcod_comp(int cod_comp) {
        this.cod_comp = cod_comp;
    }

    public int getCod_productoFK() {
        return cod_productoFK;
    }
    
    public void setCod_productoFK(int cod_productoFK) {
        this.cod_productoFK = cod_productoFK;
    }

    public String getbodega_deta_comp() {
        return bodega_deta_comp;
    }

    public void setbodega_deta_comp(String bodega_deta_comp) {
        this.bodega_deta_comp = bodega_deta_comp;
    }
    
    public int getcatidad_deta_comp() {
        return catidad_deta_comp;
    }

    public void setcatidad_deta_comp(int catidad_deta_comp) {
        this.catidad_deta_comp = catidad_deta_comp;
    }

    public int getpreciouni_deta_comp() {
        return preciouni_deta_comp;
    }

    public void setpreciouni_deta_comp(int preciouni_deta_comp) {
        this.preciouni_deta_comp = preciouni_deta_comp;
    }
    
    public int getpreciototal_deta_comp() {
        return preciototal_deta_comp;
    }

    public void setSpreciototal_deta_comp(int preciototal_deta_comp) {
        this.preciototal_deta_comp = preciototal_deta_comp;
    }    
    
}
