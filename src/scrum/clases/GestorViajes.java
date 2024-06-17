package scrum.clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GestorViajes {

	static HashSet<Viaje> listaViajes = new HashSet<>();
	static Scanner sc = new Scanner(System.in);
	
	public static boolean agregar() {
		
		Viaje v;
		double precio;
		String lugar;
		String fecha;
		boolean agregadoBien = false;
		
		System.out.println("Introduzca un lugar para el viaje");
		lugar = sc.nextLine();
		
		System.out.println("Introduzca una fecha para el viaje");
		fecha = sc.nextLine();
		
		System.out.println("Introduzca un precio para el viaje");
		precio = sc.nextDouble();
		sc.nextLine();
		
		v = new Viaje(lugar, fecha, precio);
		
		if(listaViajes.add(v)) {
			
			agregadoBien = true;
			
		}
		
		return agregadoBien;
		
	}
	
	public static void listarViajes() {
		
		for(Viaje v: listaViajes) {
			
			System.out.println(v);
			
		}
		
	}
	
	public static Viaje buscar() {
		
		Viaje viajeBuscar = null;
		String lugar;
		ArrayList<Viaje> viajesEncontrados = new ArrayList<>();
		int indice = -1;
		
		System.out.println("Introduzca un viaje a buscar por su lugar");
		lugar = sc.nextLine();
		
		viajeBuscar = new Viaje(lugar); 
		
		for(Viaje v: listaViajes) {
			
			if(v.equals(viajeBuscar)) {
				
				viajesEncontrados.add(v);
				
			}
			
		}
		
		if(viajesEncontrados.size() >= 2) {
			
			for(int i = 0; i < viajesEncontrados.size(); i++) {
				
				System.out.println(i + " Lugar: " + viajesEncontrados.get(i).getLugar() + ", Fecha: " + viajesEncontrados.get(i).getFecha() + ", Precio: " + viajesEncontrados.get(i).getPrecio());
				
			}
			
			do {
				
			} while(indice < 0 || indice > viajesEncontrados.size());
			
			System.out.println("Elija un viaje por el indíce que aparece al inicio");
			
			indice = sc.nextInt();
			sc.nextLine();
			
			viajeBuscar = viajesEncontrados.get(indice);
			
		} else {
			
			viajeBuscar = viajesEncontrados.get(0);
			
		}
		
		return viajeBuscar;
	}
	
	
	
}
