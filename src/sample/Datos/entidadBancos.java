package sample.Datos;

public class entidadBancos {

    private int numeroSemana;
    private float Monto;
    private String Descripcion;

    public entidadBancos(int numeroSemana, float monto, String descripcion) {
        this.numeroSemana = numeroSemana;
        Monto = monto;
        Descripcion = descripcion;
    }

    public entidadBancos() {}

    public int getNumeroSemana() {
        return numeroSemana;
    }

    public void setNumeroSemana(int numeroSemana) {
        this.numeroSemana = numeroSemana;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
