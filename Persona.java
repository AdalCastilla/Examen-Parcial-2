package Examen2;

public abstract class Persona {

	private String nombre;
	private boolean esAlto;
	private boolean usaGorra;
	private boolean esAtractiva;
	private boolean tienePareja;
	
	public Persona() {
		
	}
	
	
	public Persona(String nombre, boolean esAlto, boolean usaGorra, boolean esAtractiva, boolean tienePareja) {
		this.nombre=nombre;
		this.esAlto=esAlto;
		this.usaGorra=usaGorra;
		this.esAtractiva=esAtractiva;
		this.tienePareja=tienePareja;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean esAlto() {
		return esAlto;
	}
	
	public boolean usaGorra() {
		return usaGorra;
	}
	
	public boolean esAtractiva() {
		return esAtractiva;
	}
	
	public boolean tienePareja() {
		return tienePareja;
	}
}
