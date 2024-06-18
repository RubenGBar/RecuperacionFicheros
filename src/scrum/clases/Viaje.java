package scrum.clases;

public class Viaje {

	private String lugar = "";
	private String fecha = "dd/mm/aaaa";
	private double precio = 0;
	
	public Viaje(String lugar, String fecha, double precio) {
		if(lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
		if(fecha != null && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			this.fecha = fecha;
		}
		if(precio > 0) {
			this.precio = precio;
		}
		
	}

	public Viaje(String lugar) {
		if(lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio > 0) {
			this.precio = precio;
		}
	}

	public String getLugar() {
		return lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		if(fecha != null && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			this.fecha = fecha;
		}
	}

	@Override
	public String toString() {
		String cad = "\n";
		
		cad += "Viaje a " + this.lugar + "\n";
		cad += "Fecha: " + this.fecha + "\n";
		cad += "Precio: " + this.precio + "\n";
		cad += "-------------------------------------------";
		
		return cad;
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean iguales = false;
		Viaje viaje = (Viaje) o;
		
		if(this.lugar.equals(viaje.lugar)) {
			
			if(this.fecha.equals(viaje.fecha)) {
				
				iguales = true;
				
			}
			
		}
		
		return iguales;
	}
	
}
