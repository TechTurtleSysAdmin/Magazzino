import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Magazzino {
	private Map<Articolo,Integer> articolo2quantita;
	public Magazzino() {
		this.articolo2quantita = new HashMap<Articolo,Integer>();
	}
	
	public void aggiungiArticolo(Articolo articolo, int quantita){
		articolo2quantita.put(articolo, quantita);
	}

	public int calcolaValoreMagazzino() {
		int valore = 0;
		for(Articolo articolo : articolo2quantita.keySet()) {
			valore = valore +  (articolo.getCostoUnitario() * articolo2quantita.get(articolo));
		}
		return valore;
	}
	
	public Map<Integer,Set<String>> articoliEconomici(int soglia) {
		// costo -> insieme di codici di articoli con il costo della chiave
		Map<Integer,Set<String>> costo2insiemeCodiceArticoli;
		costo2insiemeCodiceArticoli = new HashMap<Integer,Set<String>>();
		// DOMANDA 3: scrivere codice mancante
		for(Articolo articolo: articolo2quantita.keySet()) {
			if(articolo.getCostoUnitario() < soglia) {
				if(costo2insiemeCodiceArticoli.containsKey(articolo.getCostoUnitario())) {
					costo2insiemeCodiceArticoli.get(articolo.getCostoUnitario()).add(articolo.getCodice());
				}
				else {
					Set<String> temp = new HashSet<String>();
					temp.add(articolo.getCodice());
					costo2insiemeCodiceArticoli.put(articolo.getCostoUnitario(), temp);
				}
			}
		}
		return costo2insiemeCodiceArticoli;
	}
	
	public List<Articolo> articoliOrdinatiPerCosto() {
		List<Articolo> listaArticoli = new LinkedList<Articolo>();
		// DOMANDA 4: scrivere codice mancante
		for (Articolo articolo : articolo2quantita.keySet()) {
			listaArticoli.add(articolo);
		}
		List<Articolo> ordinati = new LinkedList<Articolo>();
		Collections.sort(listaArticoli);
		return listaArticoli;
	}
	
	
	public Set<Articolo> getArticoli(){
		return this.articolo2quantita.keySet();
	}
	

}
