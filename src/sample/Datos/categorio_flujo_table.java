package sample.Datos;

public class categorio_flujo_table {

    private int idCategoria;
    private String fecha,Descripcion,Categoria,subCategoria,tipoOperacion,clasificacion;
    private String DescripcionNueva,tipoOperacionNueva;
    private Float Monto,MontoNuevo;

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public categorio_flujo_table(int idCategoria, String fecha, String descripcionNueva, float montoNuevo, String tipoOperacionNueva, String descripcion, float monto, String tipoOperacion) {
        this.idCategoria = idCategoria;
        this.fecha = fecha;
        Descripcion = descripcion;
        this.tipoOperacion = tipoOperacion;
        DescripcionNueva = descripcionNueva;
        this.tipoOperacionNueva = tipoOperacionNueva;
        Monto = monto;
        MontoNuevo = montoNuevo;
    }

    public categorio_flujo_table(String fecha, String descripcion, String categoria, String subCategoria) {
        this.fecha = fecha;
        Descripcion = descripcion;
        Categoria = categoria;
        this.subCategoria = subCategoria;
    }

    public String getDescripcionNueva() {
        return DescripcionNueva;
    }

    public void setDescripcionNueva(String descripcionNueva) {
        DescripcionNueva = descripcionNueva;
    }

    public String getTipoOperacionNueva() {
        return tipoOperacionNueva;
    }

    public void setTipoOperacionNueva(String tipoOperacionNueva) {
        this.tipoOperacionNueva = tipoOperacionNueva;
    }

    public Float getMontoNuevo() {
        return MontoNuevo;
    }

    public void setMontoNuevo(Float montoNuevo) {
        MontoNuevo = montoNuevo;
    }

    public categorio_flujo_table() {
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Float getMonto() {
        return Monto;
    }

    public void setMonto(Float monto) {
        Monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }
}
