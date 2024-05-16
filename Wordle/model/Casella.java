/**
 * Questa classe rappresenta una casella del gioco Wordle, contenente una lettera e le relative proprietà di colore.
 * 
 * @author bortoluzzi fois
 */
package model;

import java.awt.Color;

public class Casella {
	private char lettera;
	private ColoreRisposta coloreRisposta;
	
	/**
	 * Costruttore della classe Casella.
	 * 
	 * @param lettera la lettera contenuta nella casella
	 * @param coloreBackground il colore di sfondo della casella
	 * @param coloreTesto il colore del testo nella casella
	 */
	public Casella(char lettera, Color coloreBackground, Color coloreTesto) {
		this.lettera = lettera;
		this.coloreRisposta = new ColoreRisposta(coloreBackground, coloreTesto);
	}
	
	/**
	 * Restituisce la lettera contenuta nella casella.
	 * 
	 * @return la lettera contenuta nella casella
	 */
	public char getLettera() {
		return lettera;
	}
	
	/**
	 * Restituisce il colore di sfondo della casella.
	 * 
	 * @return il colore di sfondo della casella
	 */
	public Color getColoreBackground() {
		return coloreRisposta.getColoreBackground();
	}
	
	/**
	 * Restituisce il colore del testo nella casella.
	 * 
	 * @return il colore del testo nella casella
	 */
	public Color getColoreTesto() {
		return coloreRisposta.getColoreTesto();
	}
}
