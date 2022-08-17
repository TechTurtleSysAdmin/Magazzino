import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MagazzinoTest {
	private Magazzino magazzino;
	@Before
	public void setUp() throws Exception {
		magazzino = new Magazzino();
	}

	@Test
	public void testMagazzinoVuoto() {
		assertEquals(0, this.magazzino.calcolaValoreMagazzino());
	}
	
	@Test
	public void testMagazzinoUnSoloElemento() {
		Articolo disco = new Disco("A", 10);
		this.magazzino.aggiungiArticolo(disco, 2);
		assertEquals(20, this.magazzino.calcolaValoreMagazzino());
	}
	
	@Test
	public void testMagazzinoPiuElementi() {
		Articolo disco = new Disco("A",10);
		Articolo libro = new Libro("B",20);
		this.magazzino.aggiungiArticolo(disco, 2);
		this.magazzino.aggiungiArticolo(libro, 3);
		assertEquals(80, this.magazzino.calcolaValoreMagazzino());
	}
	
	@Test
	public void testArticoloEconomici() {
		Articolo disco = new Disco("A",10);
		Articolo libro = new Libro("B",20);
		Articolo disco_uno = new Disco("C",30);
		Articolo libro_uno = new Libro("D",40);
		this.magazzino.aggiungiArticolo(disco, 1);
		this.magazzino.aggiungiArticolo(libro, 1);
		this.magazzino.aggiungiArticolo(disco_uno, 1);
		this.magazzino.aggiungiArticolo(libro_uno, 1);
		Map<Integer, Set<String>> temp = new HashMap<Integer,Set<String>>();
		temp = this.magazzino.articoliEconomici(30);
		assertEquals(2, temp.size());
	}
	
	
	@Test
	public void testSort() {
		Articolo disco = new Disco("A",30);
		Articolo libro = new Libro("B",20);
		this.magazzino.aggiungiArticolo(disco, 1);
		this.magazzino.aggiungiArticolo(libro, 1);
		for(Articolo articolo : this.magazzino.articoliOrdinatiPerCosto()) {
			System.out.println("codice articolo: "+ articolo.getCodice()+ "\n" + "prezzo articolo: "+ articolo.getCostoUnitario() );
		}
	}
}
