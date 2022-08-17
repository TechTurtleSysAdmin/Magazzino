
public class Libro implements Articolo{
	private String codice;
	private int costoUnitario;
	
	public Libro(String codice, int costoUnitario) {
		this.codice = codice;
		this.costoUnitario = costoUnitario;
	}
	public String getCodice(){ 
		return this.codice; 
	}
	public int getCostoUnitario(){ 
		return this.costoUnitario; 
	}
	public boolean equals(Object o) {
		Libro l = (Libro)o;
		return this.codice.equals(l.getCodice());
	}
	public int hashCode() { 
		return this.codice.hashCode(); 
	}

	@Override
	public int compareTo(Articolo articolo) {
		// TODO Auto-generated method stub
		return this.getCostoUnitario() - articolo.getCostoUnitario();
	}
}
