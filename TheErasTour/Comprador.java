public class Comprador {
    private String nombre;
    private String email;
    private int presupuesto;
    private int boletosComprados;

    public Comprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
        this.boletosComprados = 0;
    }

    public String comprarBoletos(Localidad localidad, int cantidad) {
        if (boletosComprados + cantidad > 6) {
            return "Error: No puede comprar más de 6 boletos.";
        }
        String resultado = localidad.venderBoletos(cantidad, presupuesto);
        if (!resultado.contains("Error")) {
            boletosComprados += cantidad;
        }
        return resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public int getBoletosComprados() {
        return boletosComprados;
    }
}
