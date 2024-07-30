public class Boletos {
    private String fecha;
    private int contador;
    private String numeroBoleto;

    public Boletos(String fecha, int contador) {
        this.fecha = fecha;
        this.contador = contador;
        this.numeroBoleto = generarNumeroBoleto();
    }

    private String generarNumeroBoleto() {
        return fecha.replace("-", "") + String.format("%03d", contador);
    }

    public String getFecha() {
        return fecha;
    }

    public int getContador() {
        return contador;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }
}
