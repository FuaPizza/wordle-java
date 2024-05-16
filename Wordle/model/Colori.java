/**
 * Questa classe gestisce la configurazione dei colori utilizzati nell'applicazione,
 * tra cui i colori delle caselle, del testo, dei bordi e dello sfondo.
 * 
 * @author bortoluzzi fois 
 */
package model;

import java.awt.Color;

public class Colori {
	
	/** Colore per le caselle con lettere assenti. */
	public static Color ASSENTE = new Color(58, 58, 60);
	
	/** Colore per le caselle con lettere presenti ma non corrette. */
	public static Color PRESENTE = new Color(181, 159, 59);
	
	/** Colore per le caselle con lettere corrette. */
	public static Color CORRETTO = new Color(83, 141, 78);
	
	/** Colore del testo nelle caselle. */
	public static Color TESTO = new Color(255, 255, 255);
	
	/** Colore predefinito per le caselle. */
	public static Color PREDEFINITO = new Color(50, 50, 50);
	
	/** Colore dei bordi delle caselle. */
	public static Color BORDI = new Color(220, 220, 220);
	
	/** Colore di sfondo generale. */
	public static Color SFONDO = new Color(20, 20, 20);
}
