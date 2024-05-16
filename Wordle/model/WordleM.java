/**
 * Questa classe gestisce tutte le logiche del gioco di base, inclusa la verifica delle lettere inserite rispetto alla parola da indovinare.
 * 
 * @author bortoluzzi fois
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import control.ListaParole;

public class WordleM {

	private char[] parola, indovino;
	
	private final int colonne, righe;
	private int curColonna, curRiga;
	
	private ArrayList<String> listaparole;
	
	private Casella[][] grigliaWordle;
	
	public WordleM() {
		this.curColonna = -1;
		this.curRiga = 0;
		
		this.colonne = 5;
		this.righe = 6;
		
		this.indovino = new char[colonne];
		this.grigliaWordle = inizializzaGriglia();
		
		creaListaParole();
	}
	
	/**
	 * Crea la lista delle parole per il gioco.
	 */
	private void creaListaParole() {
		 ListaParole r = new ListaParole(this);
		 new Thread(r).start();
	}
	
	/**
	 * Inizializza la griglia del gioco.
	 * 
	 * @return La griglia del gioco inizializzata
	 */
	private Casella[][] inizializzaGriglia() {
		Casella[][] grigliaWordle = new Casella[righe][colonne];
		
		for (int r = 0; r < righe; r++) {
			for (int c = 0; c < colonne; c++) {
				grigliaWordle[r][c] = null;
			}
		}
		
		return grigliaWordle;
	}
	
	/**
	 * Inizializza il gioco.
	 */
	public void inizializza() {
		this.curColonna = -1;
		this.curRiga = 0;
		
		generaParolaRandom();
		
		this.indovino = new char[colonne];
		this.grigliaWordle = inizializzaGriglia();
	}
	
	/**
	 * Imposta una lettera nella griglia del gioco.
	 * 
	 * @param lettera La lettera da impostare
	 */
	public void setLettera(char lettera) {
		this.curColonna++;
		this.curColonna = Math.min(curColonna, (colonne - 1));
		
		indovino[curColonna] = lettera;
		grigliaWordle[curRiga][curColonna] = new Casella(lettera, Colori.PREDEFINITO, Colori.TESTO);
	}
	
	/**
	 * Cancella l'ultima lettera inserita.
	 */
	public void cancellaLettera() {
		grigliaWordle[curRiga][curColonna] = null;
		indovino[curColonna] = ' ';
		
		this.curColonna--;
		this.curColonna = Math.max(curColonna, -1);
	}
	
	/**
	 * Rivela la riga corrente del gioco.
	 * 
	 * @return true se ci sono ancora righe da rivelare, false altrimenti
	 */
	public boolean rivelaRiga() {
		for (int colonna = 0; colonna < indovino.length; colonna++) {
			Color coloreBackground = Colori.PREDEFINITO;
			
			if (indovino[colonna] == parola[colonna]) {
				coloreBackground = Colori.CORRETTO;
			}
			else if (contiene(parola, indovino, colonna)) {
				coloreBackground = Colori.PRESENTE;
			}
			
			grigliaWordle[curRiga][colonna] = new Casella(indovino[colonna], coloreBackground, Colori.TESTO);
		}
		
		curColonna = -1;
		curRiga++;
		indovino = new char[colonne];
		
		return curRiga < righe;
	}

	/**
	 * Verifica se una lettera è presente in una data posizione.
	 * 
	 * @param parola La parola da confrontare
	 * @param indovino L'array di lettere indovinate
	 * @param indice L'indice della lettera da controllare
	 * @return true se la lettera è presente in un'altra posizione della parola, false altrimenti
	 */
	private boolean contiene(char[] parola, char[] indovino, int indice) {
		for (int i = 0; i < this.parola.length; i++) {
			if (i != indice && indovino[indice] == parola[i]){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Imposta la lista delle parole per il gioco.
	 * 
	 * @param listaparole La lista delle parole
	 */
	public void setListaparole(ArrayList<String> listaparole) {
		this.listaparole = listaparole;
	}
	
	/**
	 * Prende una parola random dalla lista delle parole.
	 * 
	 * @return Una parola random
	 */
	private String prendiParolaRandom() {
		return listaparole.get(new Random().nextInt(listaparole.size()));
	}
	
	/**
	 * Genera una parola random per il gioco.
	 */
	public void generaParolaRandom() {
		String parola = prendiParolaRandom();
		this.parola = parola.toUpperCase().toCharArray();
	}
	
	/**
	 * Ottiene la riga corrente del gioco.
	 * 
	 * @return La riga corrente del gioco
	 */
	public Casella[] getCurRiga() {
		return grigliaWordle[getCurNumeroRiga()];
	}
	
	/**
	 * Ottiene il numero della riga corrente del gioco.
	 * 
	 * @return Il numero della riga corrente del gioco
	 */
	public int getCurNumeroRiga() {
		return curRiga - 1;
	}
	
	/**
	 * Ottiene la griglia del gioco.
	 * 
	 * @return La griglia del gioco
	 */
	public Casella[][] getGrigliaWordle() {
		return grigliaWordle;
	}
	
	/**
	 * Ottiene il numero di righe della griglia del gioco.
	 * 
	 * @return Il numero di righe della griglia del gioco
	 */
	public int getRighe() {
		return righe;
	}
	
	/**
	 * Ottiene il numero di colonne della griglia del gioco.
	 * 
	 * @return Il numero di colonne della griglia del gioco
	 */
	public int getColonne() {
		return colonne;
	}
	
	/**
	 * Ottiene la colonna corrente del gioco.
	 * 
	 * @return La colonna corrente del gioco
	 */
	public int getCurColonna() {
		return curColonna;
	}
	
}
