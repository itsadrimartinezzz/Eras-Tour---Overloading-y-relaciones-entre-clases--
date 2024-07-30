import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int capacidad1 = 10;
        int capacidad2 = 10;
        int capacidad3 = 10;
        Scanner scanner = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        SistemaBoletos sistema = new SistemaBoletos(fechaActual.format(formatter));

        // Configurar localidades
        String nombre1 = "Alejada";
        System.out.print("Nombre Localidad 1: " + nombre1 + "\n");
        int precio1 = 100;
        System.out.print("Precio del boleto para la Localidad 1: $" + precio1);
        scanner.nextLine(); // Consumir nueva línea

        String nombre2 = "Medio";
        System.out.print("Nombre Localidad 2: " + nombre2 + "\n");
        int precio2 = 500;
        System.out.print("Precio del boleto para la Localidad 2: $" + precio2);
        scanner.nextLine(); // Consumir nueva línea

        String nombre3 = "Adelante";
        System.out.print("Nombre Localidad 3: " + nombre3 + "\n");
        int precio3 = 1000;
        System.out.print("Precio del boleto para la Localidad 3: $" + precio3);
        scanner.nextLine(); // Consumir nueva línea

        sistema.configurarLocalidades(nombre1, capacidad1, precio1,
                                      nombre2, capacidad2, precio2,
                                      nombre3, capacidad3, precio3);

        int opcion;
        do {
            System.out.println("Bienvenido al sistema de venta de boletos de The Eras Tour");
            System.out.println("1. Agregar comprador");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad por localidad");
            System.out.println("5. Generar reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del comprador: ");
                    String nombreComprador = scanner.nextLine();
                    System.out.print("Ingrese el email del comprador: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese el presupuesto del comprador: ");
                    int presupuesto = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea
                    sistema.agregarComprador(nombreComprador, email, presupuesto);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del comprador: ");
                    nombreComprador = scanner.nextLine();
                    Comprador comprador = sistema.getComprador(nombreComprador);
                    if (comprador == null) {
                        System.out.println("Comprador no encontrado.");
                        break;
                    }
                    System.out.print("Ingrese el nombre de la localidad: ");
                    String nombreLocalidad = scanner.nextLine();
                    Localidad localidad = sistema.getLocalidad(nombreLocalidad);
                    if (localidad == null) {
                        System.out.println("Localidad no encontrada.");
                        break;
                    }
                    System.out.print("Ingrese la cantidad de boletos a comprar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea
                    String resultadoCompra = sistema.solicitarCompraBoletos(comprador, localidad, cantidad);
                    System.out.println(resultadoCompra);
                    break;

                case 3:
                    System.out.println("Disponibilidad total de boletos:");
                    System.out.println(sistema.getLocalidad(nombre1).getNombre() + ": " + sistema.getLocalidad(nombre1).getBoletosDisponibles() + " boletos disponibles");
                    System.out.println(sistema.getLocalidad(nombre2).getNombre() + ": " + sistema.getLocalidad(nombre2).getBoletosDisponibles() + " boletos disponibles");
                    System.out.println(sistema.getLocalidad(nombre3).getNombre() + ": " + sistema.getLocalidad(nombre3).getBoletosDisponibles() + " boletos disponibles");
                    break;

                case 4:
                    System.out.print("Ingrese el nombre de la localidad: ");
                    nombreLocalidad = scanner.nextLine();
                    localidad = sistema.getLocalidad(nombreLocalidad);
                    if (localidad == null) {
                        System.out.println("Localidad no encontrada.");
                    } else {
                        System.out.println("Disponibilidad en " + localidad.getNombre() + ": " + localidad.getBoletosDisponibles() + " boletos disponibles");
                    }
                    break;

                case 5:
                    System.out.println(sistema.generarReporte());
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
