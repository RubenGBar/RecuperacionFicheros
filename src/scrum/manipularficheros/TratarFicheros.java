package scrum.manipularficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import scrum.clases.GestorViajes;
import scrum.clases.Viaje;

public class TratarFicheros {
	
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static String ruta = "src/scrum/ficheros/datosTurismo.txt";
	
	public static void rellenar() {
		
		String linea;
		String[] elementos;
		Viaje viaje;
		
		try {
			
			br = new BufferedReader(new FileReader(ruta));
			
			linea = br.readLine();
			
			while(linea != null) {
				
				elementos = linea.split("::");
				viaje = new Viaje(elementos[0], elementos[1], Integer.parseInt(elementos[2]));
				GestorViajes.getListaViajes().add(viaje);
				
				linea = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
		
			System.err.println(e);
			
		} catch (IOException e) {
			
			System.err.println(e);
			
		} finally {
			
			try {
				
				br.close();
				
			} catch (IOException e) {
				
				System.out.println(e);
				
			}
			
		}
		
	}
	
	public static void guardar() {
		
		try {
			
			bw = new BufferedWriter(new FileWriter(ruta));
			
			for(Viaje v: GestorViajes.getListaViajes()) {
				
				bw.write(v.getLugar() + "::" + v.getFecha() + "::" + v.getPrecio());
				bw.newLine();
				
			}
			
		} catch (IOException e) {
			
			System.err.println(e);
			
		} finally {
			
			try {
				
				bw.flush();
				bw.close();
				
			} catch (IOException e) {
				
				System.out.println(e);
				
			}
			
		}
		
	}

}
