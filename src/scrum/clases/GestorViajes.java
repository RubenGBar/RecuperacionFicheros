package scrum.clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GestorViajes {

	static HashSet<Viaje> listaViajes = new HashSet<>();
	static Scanner sc = new Scanner(System.in);
	
	public static HashSet<Viaje> getListaViajes() {
		return listaViajes;
	}
	
	public static void agregar(Viaje v) {
		
		if(listaViajes.add(v)) {
			
			System.out.println("Se ha añadido el viaje");
			
		} else {
			
			System.out.println("No se ha podido añadir el viaje");
			
		}
		

	}
	
	public static void listarViajes() {
		
		for(Viaje v: listaViajes) {
			
			System.out.println(v);
			
		}
		
	}
	
	public static Viaje buscar(String lugar) {
		
		ArrayList<Viaje> viajesEncontrados = new ArrayList<>();
		int indice = -1;
		Viaje viajeBuscar;
		
		for(Viaje v: listaViajes) {
			
			if(v.getLugar().equals(lugar)) {
				
				viajesEncontrados.add(v);
				
			}
			
		}
		
		for(int i = 0; i < viajesEncontrados.size(); i++) {
			
			System.out.println(i + " Lugar: " + viajesEncontrados.get(i).getLugar() + ", Fecha: " + viajesEncontrados.get(i).getFecha() + ", Precio: " + viajesEncontrados.get(i).getPrecio());
			
		}
		
		if(viajesEncontrados.size() >= 2) {
			
			do {
				
				System.out.println("Elija un viaje por el indíce que aparece al inicio");
				
				try {
					
					indice = sc.nextInt();
					sc.nextLine();
					
				}catch(IllegalArgumentException e) {
					
					System.err.println("Tipo de dato incorrecto");
					sc.nextLine();
					
				}
				
			} while(indice < 0 || indice > viajesEncontrados.size());
			
		} else {
			
			indice = 0;
			
		}
		
		viajeBuscar = viajesEncontrados.get(indice);
		
		return viajeBuscar;
	}
	
	public static boolean eliminar(String lugar) {
		
		boolean eliminado = false;
		Viaje viajeEliminar = buscar(lugar);
		
		eliminado = listaViajes.remove(viajeEliminar);
		
		return eliminado;
	}
	
	public static boolean modificar(String lugar) {
		
		boolean modificado = false;
		Viaje viajeModificar = buscar(lugar);
		Viaje viajeModificado;
		double precio;
		String fecha;
		int opc;
		
		System.out.println("¿Qué quiere modificar?");
		System.out.println("1. Fecha");
		System.out.println("2. Precio");
		
		do {
			
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
			
				case 1 -> {
					
					System.out.println("Introduzca una nueva fecha");
					fecha = sc.nextLine();
					
					viajeModificado = new Viaje(viajeModificar.getLugar(), fecha, viajeModificar.getPrecio());
					
					listaViajes.remove(viajeModificar);
					
					listaViajes.add(viajeModificado);
					
					modificado = true;
				}
				
				case 2 -> {
					
					System.out.println("Introduzca un nuevo precio");
					precio = sc.nextDouble();
					sc.nextLine();
					
					viajeModificado = new Viaje(viajeModificar.getLugar(), viajeModificar.getFecha(), precio);
					
					listaViajes.remove(viajeModificar);
					
					listaViajes.add(viajeModificado);
					
					modificado = true;
					
				}
				
				default -> {
					
					System.out.println("Opción introducida incorrecta");
					
				}
			
			}
			
		}while(!modificado && opc < 1 || opc > 2);
		
		return modificado;
	}

}
