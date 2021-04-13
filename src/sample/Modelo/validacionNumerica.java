package sample.Modelo;

public class validacionNumerica {

    public boolean validarDatosEnteros(String dato) {
        return dato.matches("[0-9]*");
    }

    public boolean validarDatosDecimales(String dato) {
        return dato.matches("[0-9]*\\.?[0-9]*");
    }

}
