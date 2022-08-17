
public interface Articolo extends Comparable<Articolo>{
	public String getCodice();
	public int getCostoUnitario();
	public int compareTo(Articolo articolo);
}
