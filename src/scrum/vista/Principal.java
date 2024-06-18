package scrum.vista;

import java.util.Scanner;

import scrum.clases.GestorViajes;
import scrum.clases.Viaje;
import scrum.manipularficheros.TratarFicheros;

public class Principal {
	
	public static void main(String[] args) {
		
		String lugar;
		String fecha;
		double precio;
		Viaje viaje;
		int opc;
		Scanner sc = new Scanner(System.in);
		
		GestorViajes.rellenarLista();
		
		do {
			
			menu();
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
			
				case 1 -> { // Listar
					
					GestorViajes.listarViajes();
					
				}
				
				case 2 -> { // Añadir
					
					System.out.println("Introduzca un lugar para el viaje");
					lugar = sc.nextLine();
					
					System.out.println("Introduzca una fecha para el viaje");
					fecha = sc.nextLine();
					
					System.out.println("Introduzca un precio para el viaje");
					precio = sc.nextDouble();
					
					viaje = new Viaje(lugar, fecha, precio);
					GestorViajes.agregar(viaje);
					
				}
				
				case 3 -> { // Modificar
					
					System.out.println("Introduzca el lugar del viaje a modificar");
					lugar = sc.nextLine();
					
					GestorViajes.modificar(lugar);
					
				}
				
				case 4-> { // Eliminar
					
					System.out.println("Introduzca el lugar del viaje a eliminar");
					lugar = sc.nextLine();
					
					GestorViajes.eliminar(lugar);
					
				}
				
				case 5 -> { // Guardar
					
					GestorViajes.gurdarEnLista();
					System.out.println("Se han guardado los viajes");
					
				}
			}
			
		}while(opc != 0);
		
		System.out.println("Saliendo del programa...");
		
		
	}

	public static void menu() {
		
		System.out.println("Elija una opción");
		System.out.println("1. Listar");
		System.out.println("2. Añadir");
		System.out.println("3. Modificar");
		System.out.println("4. Eliminar");
		System.out.println("5. Guardar");
		System.out.println("0. Salir");
		
	}
	
}
