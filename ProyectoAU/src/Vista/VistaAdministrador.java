
package vista;

import Persistencia.IGuardadoRuta;
import entidades.Administrador;
import entidades.Ruta;
import Persistencia.ListaRuta;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Scanner;

public class VistaAdministrador {
    private Administrador Administrador;
    private ListaRuta listaRuta;
    private IGuardadoRuta guardadoRuta = new IGuardadoRuta();
    
        
     public VistaAdministrador(Administrador administrador, ListaRuta listaRuta, IGuardadoRuta guardadoRuta) {
        this.Administrador = administrador;
        this.listaRuta = listaRuta;
        this.guardadoRuta = guardadoRuta;
    }
    
     
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();
        
        while (!salir) {

            if (contraseña.equals(Administrador.getContraseña())) {
                System.out.println("Inicio de sesion correcto.");
                System.out.println("  ");
                System.out.println("╔══════════════════════════════════╗");
                System.out.println("║    Menú del Administrador   ║");
                System.out.println("║══════════════════════════════════║");
                System.out.println("║ 1. Modificar precio de ruta ║");
                System.out.println("║ 2. Ingresar una nueva Ruta  ║");
                System.out.println("║ 3. Consultar una ruta       ║");
                System.out.println("║ 4. Mostrar todas las rutas  ║");
                System.out.println("║ 5. Salir                    ║");
                System.out.println("║══════════════════════════════════║");
                System.out.print("Seleccione una opcion: ");


                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        modificarPrecioRuta();
                        break;
                    case 2:
                        AgregarRuta();
                        break;
                    case 3:
                        consultarRuta();
                        break;
                    case 4:
                        mostrarRutas();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Contraseña incorrecta.");
                salir = true;
            }
        }
    }
    
    public void AgregarRuta(){
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos de la nueva ruta:");
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Hora (HH:mm): ");
        String horaStr = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaStr);
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        

        Ruta nuevaRuta = new Ruta(origen, destino, hora, fecha, codigo, precio);
        
        this.guardadoRuta.agregarRuta(nuevaRuta);


        listaRuta.mostrarRutas();

        scanner.close();
    
    
    }

    public void modificarPrecioRuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de la ruta a modificar: ");
        String codigo = scanner.nextLine();

        Ruta ruta = listaRuta.consultarRuta(codigo);

        if (ruta != null) {
            System.out.print("Ingrese el nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();
            Administrador.modificarPrecioRuta(ruta, nuevoPrecio);
            System.out.println("Precio de la ruta modificado exitosamente.");
        } else {
            System.out.println("La ruta no existe.");
        }
    }

    public void consultarRuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de la ruta a consultar: ");
        String codigo = scanner.nextLine();
        Ruta ruta = listaRuta.consultarRuta(codigo);
        
        if (ruta != null) {
        System.out.println("Información de la ruta consultada:");
        System.out.println("Código: " + ruta.getCodigo());
        System.out.println("Origen: " + ruta.getOrigen());
        System.out.println("Destino: " + ruta.getDestino());
        System.out.println("Hora: " + ruta.getHora());
        System.out.println("Fecha: " + ruta.getFecha());
        System.out.println("Precio: " + ruta.getPrecio());
    } else {
        System.out.println("La ruta no existe.");
    }
 }

    public void mostrarRutas() {
        listaRuta.mostrarRutas();
    }
 }

