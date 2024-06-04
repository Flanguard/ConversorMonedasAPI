package GuardarDatosAplicacion;

public class GuardarDatos {
    private String tipoCambio;
    private String cambio_Desde;
    private String cambio_Hacia;
    private Double dineroIngresado;
    private Double totalConvertido;

    public GuardarDatos(String tipoCambio,
                        String cambio_Hacia,
                        String cambio_Desde,
                        Double dineroIngresado,
                        Double totalConvertido) {
        this.tipoCambio = tipoCambio;
        this.cambio_Hacia = cambio_Hacia;
        this.cambio_Desde = cambio_Desde;
        this.dineroIngresado = dineroIngresado;
        this.totalConvertido = totalConvertido;
    }

    @Override
    public String toString() {
        return  "Tipo de cambio: " + tipoCambio + '\'' +
                ", Valor ingresado: " + dineroIngresado + " "+ cambio_Desde +'\'' +
                ", Total: " + totalConvertido + " "+ cambio_Hacia +'\'' +
                '}';
    }
}
