package sample.Datos;

public class entidadCuentas {

    private int numeroSemana;
    private String razonSocial;
    private float Monto;
    private String tipoOperacion;

    public entidadCuentas(int numeroSemana, String razonSocial, float monto, String tipoOperacion) {
        this.numeroSemana = numeroSemana;
        this.razonSocial = razonSocial;
        Monto = monto;
        this.tipoOperacion = tipoOperacion;
    }

    public entidadCuentas() {}

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public int getNumeroSemana() {
        return numeroSemana;
    }

    public void setNumeroSemana(int numeroSemana) {
        this.numeroSemana = numeroSemana;
    }

}
