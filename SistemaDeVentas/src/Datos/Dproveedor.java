
package Datos;


public class Dproveedor extends Dpersona{

    private int cod_prov ;
    private String nombre_prov;
    private String direccion_prov;
    private String telefono_prov;
    private String nit_prov;
    

    public Dproveedor() {
    }

    public Dproveedor(int cod_prov, String nombre_prov,String direccion_prov,String telefono_prov,String nit_prov) {
        this.cod_prov = cod_prov;
        this.nombre_prov = nombre_prov;
        this.direccion_prov = direccion_prov;
        this.telefono_prov = telefono_prov;
        this.nit_prov = nit_prov;
    }

    public int getcod_prov() {
        return cod_prov;
    }

    public void setcod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
    }

    public String getnombre_prov() {
        return nombre_prov;
    }

    public void setnombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }
    

    public String getdireccion_prov() {
        return direccion_prov;
    }

    public void setdireccion_prov(String direccion_prov) {
        this.direccion_prov = direccion_prov;
    }
    

    public String gettelefono_prov() {
        return telefono_prov;
    }

    public void settelefono_prov(String telefono_prov) {
        this.telefono_prov = telefono_prov;
    }
    

    public String getnit_prov() {
        return nit_prov;
    }

    public void setnit_prov(String nit_prov) {
        this.nit_prov = nit_prov;
    }
    
    
}

