package sample.Datos;

public class entidadCategorias {

    private String categoriaNueva,clasificacionNueva,subcategoriaNueva;
    private String categoria,clasificacion,subcategoria;

    public entidadCategorias() {}

    public entidadCategorias(String categoria, String clasificacion, String subcategoria) {
        this.categoria = categoria;
        this.clasificacion = clasificacion;
        this.subcategoria = subcategoria;
    }

    public entidadCategorias(String categoriaNueva, String clasificacionNueva, String subcategoriaNueva, String categoria, String clasificacion, String subcategoria) {
        this.categoriaNueva = categoriaNueva;
        this.clasificacionNueva = clasificacionNueva;
        this.subcategoriaNueva = subcategoriaNueva;
        this.categoria = categoria;
        this.clasificacion = clasificacion;
        this.subcategoria = subcategoria;
    }

    public String getCategoriaNueva() {
        return categoriaNueva;
    }

    public void setCategoriaNueva(String categoriaNueva) {
        this.categoriaNueva = categoriaNueva;
    }

    public String getClasificacionNueva() {
        return clasificacionNueva;
    }

    public void setClasificacionNueva(String clasificacionNueva) {
        this.clasificacionNueva = clasificacionNueva;
    }

    public String getSubcategoriaNueva() {
        return subcategoriaNueva;
    }

    public void setSubcategoriaNueva(String subcategoriaNueva) {
        this.subcategoriaNueva = subcategoriaNueva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}
