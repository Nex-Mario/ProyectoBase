/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import vista.LectorDatos;
import vista.VistaAdministrador;
/**
 *
 * @author luism
 */
public class MenuPrincipal {
    
    public void menuInicial(){
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║    Menú del Inicio             ║");
        System.out.println("║═════════════════════════════════════║");
        System.out.println("║ 1. iniciar como administrador  ║");
        System.out.println("║ 2. Ingresar como usuario       ║");
        System.out.println("║ 3. Salir                       ║");
        System.out.println("║═════════════════════════════════════║");
        System.out.println(" ");
        System.out.print("Seleccione una opcion: ");
        
        int op;
        do {
            op = LectorDatos.leerInt("Seleccione una opcion");
            switch (op) {
                case 1:
                    //vistaAdmin.menuPrincipal(); LLamalo no se como hacerlo jaja
                    break;
                case 2:
                    System.out.println("Muestra de las rutas para el usuario");
                    //Aqui pon lo de mostrar las rutas
                    break;
                case 3:
                    System.out.println("Ha sido un placer, cerrando programa...");
                    break;
                default:
                    System.out.println("!! Opcion no valida ¡¡\n");

            }

        } while (op != 4);
    }    
}
