public class SistemaBoletos {
    private Localidad localidad1;
    private Localidad localidad2;
    private Localidad localidad3;
    private Comprador comprador1;
    private Comprador comprador2;
    private String fecha;

    public SistemaBoletos(String fecha) {
        this.fecha = fecha;
    }

    public void configurarLocalidades(String nombre1, int capacidad1, int precio1,
                                      String nombre2, int capacidad2, int precio2,
                                      String nombre3, int capacidad3, int precio3) {
        localidad1 = new Localidad(nombre1, capacidad1, precio1);
        localidad2 = new Localidad(nombre2, capacidad2, precio2);
        localidad3 = new Localidad(nombre3, capacidad3, precio3);
    }

    public void agregarComprador(String nombre, String email, int presupuesto) {
        if (comprador1 == null) {
            comprador1 = new Comprador(nombre, email, presupuesto);
        } else if (comprador2 == null) {
            comprador2 = new Comprador(nombre, email, presupuesto);
        } else {
            System.out.println("Máximo de compradores alcanzado.");
        }
    }

    public String solicitarCompraBoletos(Comprador comprador, Localidad localidad, int cantidad) {
        return comprador.comprarBoletos(localidad, cantidad);
    }

    public boolean verificarDisponibilidad(Localidad localidad, int cantidad) {
        return localidad.getBoletosDisponibles() >= cantidad;
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        int totalDinero = 0;

        int dineroLocalidad1 = localidad1.getBoletosVendidos() * localidad1.getPrecioBoleto();
        totalDinero += dineroLocalidad1;
        reporte.append(localidad1.getNombre())
               .append(": Vendidos ").append(localidad1.getBoletosVendidos())
               .append(", Dinero generado $").append(dineroLocalidad1)
               .append("\n");

        int dineroLocalidad2 = localidad2.getBoletosVendidos() * localidad2.getPrecioBoleto();
        totalDinero += dineroLocalidad2;
        reporte.append(localidad2.getNombre())
               .append(": Vendidos ").append(localidad2.getBoletosVendidos())
               .append(", Dinero generado $").append(dineroLocalidad2)
               .append("\n");

        int dineroLocalidad3 = localidad3.getBoletosVendidos() * localidad3.getPrecioBoleto();
        totalDinero += dineroLocalidad3;
        reporte.append(localidad3.getNombre())
               .append(": Vendidos ").append(localidad3.getBoletosVendidos())
               .append(", Dinero generado $").append(dineroLocalidad3)
               .append("\n");

        reporte.append("Total dinero generado: $").append(totalDinero);
        return reporte.toString();
    }

    public Localidad getLocalidad(String nombre) {
        if (localidad1.getNombre().equalsIgnoreCase(nombre)) {
            return localidad1;
        } else if (localidad2.getNombre().equalsIgnoreCase(nombre)) {
            return localidad2;
        } else if (localidad3.getNombre().equalsIgnoreCase(nombre)) {
            return localidad3;
        }
        return null;
    }

    public Comprador getComprador(String nombre) {
        if (comprador1 != null && comprador1.getNombre().equalsIgnoreCase(nombre)) {
            return comprador1;
        } else if (comprador2 != null && comprador2.getNombre().equalsIgnoreCase(nombre)) {
            return comprador2;
        }
        return null;
    }

    public String getFecha() {
        return fecha;
    }
}
