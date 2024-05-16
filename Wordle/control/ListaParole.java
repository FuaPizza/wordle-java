/**
 * Questa classe si occupa di creare una lista di parole ottenute da un file.
 * Una volta create, le parole vengono assegnate al modello di gioco WordleM.
 * 
 * @author bortoluzzi fois
 */
package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.WordleM;

public class ListaParole implements Runnable{
	
	private final WordleM model;
	
	/**
	 * Costruttore della classe ListaParole.
	 * 
	 * @param model il modello di gioco WordleM
	 */
	public ListaParole(WordleM model) {
		this.model = model;
	}
	
	@Override
	public void run() {
		ArrayList<String> listParole;
		
		try {
			listParole = creaListaDiParole();
		} catch (IOException e) {
			e.printStackTrace();
			listParole = new ArrayList<String>();
		}
		System.out.println("Creata lista di " + listParole.size() + " parole");
		
		model.setListaparole(listParole);
		model.generaParolaRandom();
	}
	
	/**
	 * Questo metodo crea un'ArrayList contenente le parole di lunghezza uguale al numero di colonne del modello.
	 * Le parole vengono lette da un file e aggiunte all'ArrayList.
	 * 
	 * @return la lista delle parole ottenute dal file
	 * @throws IOException se si verifica un errore durante la lettura del file
	 */
	private ArrayList<String> creaListaDiParole() throws IOException{
		int lunghezzaMin = model.getColonne();
		ArrayList<String> listParole = new ArrayList<String>();
		
		String pathname = "assets/parole.txt";
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream stream = loader.getResourceAsStream(pathname);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String riga = reader.readLine();
		while (riga != null) {
			riga = riga.trim();
			if (riga.length() == lunghezzaMin) {
				listParole.add(riga);
			}
			riga = reader.readLine();
		}
		reader.close();
		
		return listParole;
	}
}
