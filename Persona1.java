package Examen2;

public class Persona1 extends Persona{

	public String nombre;
	public boolean esAlto;
	public boolean usaGorra;
	public boolean esAtractiva;
	public boolean tienePareja;
	
	public Persona1() {
		
	}
	
	public Persona1(String nombre, boolean esAlto, boolean usaGorra, boolean esAtractiva, boolean tienePareja) {
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
