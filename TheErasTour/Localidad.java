public class Localidad {
    private String nombre;
    private int capacidad;
    private int precioBoleto;
    private int boletosVendidos;

    public Localidad(String nombre, int capacidad, int precioBoleto) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioBoleto = precioBoleto;
        this.boletosVendidos = 0;
    }

    public String venderBoletos(int cantidad, int presupuesto) {
        if (boletosVendidos + cantidad > capacidad) {
            cantidad = capacidad - boletosVendidos;
        }
        if (cantidad * precioBoleto > presupuesto) {
            return "Presupuesto insuficiente";
        }
        boletosVendidos += cantidad;
        return cantidad + " boletos vendidos para " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPrecioBoleto() {
        return precioBoleto;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public int getBoletosDisponibles() {
        return capacidad - boletosVendidos;
    }
}
