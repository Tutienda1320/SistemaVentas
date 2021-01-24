package Datos;


public class Dproducto {

    private long cod_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private String unidad_producto;
    private long precio_producto;
    private int stock_producto;
    private String ubicacion_bodega;

    public Dproducto() {
    }

    public Dproducto(long cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, long precio_producto, int stock_producto, String ubicacion_bodega) {
        this.cod_producto = cod_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.unidad_producto = unidad_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
        this.ubicacion_bodega = ubicacion_bodega;
    }

  

 

    public long getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(long cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getUnidad_producto() {
        return unidad_producto;
    }

    public void setUnidad_producto(String unidad_producto) {
        this.unidad_producto = unidad_producto;
    }

    public long getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(long precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }


    public String getUbicacion_bodega() {
        return ubicacion_bodega;
    }

    public void setUbicacion_bodega(String ubicacion_bodega) {
        this.ubicacion_bodega = ubicacion_bodega;
    }

  

}
