package sample.Modelo;

public class categoria {

    private String nombre;
    private String subcategorias;
    private String clasificacion;

    public categoria() {}

    public categoria(String nombre, String subcategorias, String clasificacion) {
        this.nombre = nombre;
        this.subcategorias = subcategorias;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(String subcategorias) {
        this.subcategorias = subcategorias;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "categoria{" +
                "nombre='" + nombre + '\'' +
                ", subcategorias='" + subcategorias + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }
}
