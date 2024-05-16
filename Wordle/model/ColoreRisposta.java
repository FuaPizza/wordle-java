/**
 * Questa classe gestisce il colore della casella in base alla risposta dell'utente.
 * 
 * @author bortoluzzi fois
 */
package model;

import java.awt.Color;

public class ColoreRisposta {
	
	private final Color coloreBackground, coloreTesto;
	
	/**
	 * Costruttore della classe ColoreRisposta.
	 * 
	 * @param coloreBackground il colore di sfondo della casella
	 * @param coloreTesto il colore del testo nella casella
	 */
	public ColoreRisposta(Color coloreBackground, Color coloreTesto) {
		this.coloreBackground = coloreBackground;
		this.coloreTesto = coloreTesto;
	}
	
	/**
	 * Restituisce il colore di sfondo della casella.
	 * 
	 * @return il colore di sfondo della casella
	 */
	public Color getColoreBackground() {
		return coloreBackground;
	}
	
	/**
	 * Restituisce il colore del testo nella casella.
	 * 
	 * @return il colore del testo nella casella
	 */
	public Color getColoreTesto() {
		return coloreTesto;
	}
	
}
