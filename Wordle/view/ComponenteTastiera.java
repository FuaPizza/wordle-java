/**
 * Questa classe rappresenta il componente della tastiera, che contiene i pulsanti per le varie lettere
 * e comandi utilizzati nel gioco.
 * 
 * @author bortoluzzi fois
 */
package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.AzioniTastiera;
import model.Colori;
import model.WordleM;

public class ComponenteTastiera extends JPanel {

	private static final long serialVersionUID = 1L;

	private int iBottone, nBottoni;
	
	private final JButton[] bottoni;
	
	private final JPanel pannello;
	
	private final AzioniTastiera azioniT;
	
		
	public ComponenteTastiera(Finestra finestra, WordleM model) {
		this.iBottone = 0;
		this.nBottoni = primaRiga().length + secondaRiga().length + terzaRiga().length;
		this.bottoni = new JButton[nBottoni];
		this.azioniT = new AzioniTastiera(finestra, model);
		this.pannello = createPanello();
	}
	
	/**
	 * Crea il pannello della tastiera.
	 * 
	 * @return Il pannello della tastiera
	 */
	private JPanel createPanello() {
		JPanel panello = new JPanel(new GridLayout(0, 1, 0, 0));
		panello.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		panello.setBackground(Colori.SFONDO);
		
		panello.add(pannelloPrimaRiga());
		panello.add(pannelloSecondaRiga());
		panello.add(pannelloTerzaRiga());
		
		return panello;
	}
	
	/**
	 * Restituisce un array di stringhe contenente le lettere della prima riga della tastiera.
	 * 
	 * @return Array di stringhe con le lettere della prima riga
	 */
	private String[] primaRiga() {
		String[] lettere = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Cancella"};
		return lettere;
	}
	
	/**
	 * Crea il pannello contenente i pulsanti della prima riga della tastiera.
	 * 
	 * @return Il pannello della prima riga della tastiera
	 */
	private JPanel pannelloPrimaRiga() {
		JPanel panello = new JPanel(new FlowLayout());
		panello.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panello.setBackground(Colori.SFONDO);

		Font fontTesto = Fonts.FONT_TESTO;
		
		String[] lettere = primaRiga();
		
		for (int i = 0; i < lettere.length; i++) {
			JButton bottone = new JButton(lettere[i]);
			bottone.setActionCommand(lettere[i]);
			bottone.addActionListener(azioniT);
			bottone.setFont(fontTesto);
			bottoni[iBottone++] = bottone;
			panello.add(bottone);
		}
		
		return panello;
	}
	
	/**
	 * Restituisce un array di stringhe contenente le lettere della seconda riga della tastiera.
	 * 
	 * @return Array di stringhe con le lettere della seconda riga
	 */
	private String[] secondaRiga() {
		String[] lettere = { "A", "S", "D", "F", "G", "H", "J", "K", "L", "Invio" };
		return lettere;
	}
	
	/**
	 * Crea il pannello contenente i pulsanti della seconda riga della tastiera.
	 * 
	 * @return Il pannello della seconda riga della tastiera
	 */
	private JPanel pannelloSecondaRiga() {
		JPanel panello = new JPanel(new FlowLayout());
		panello.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panello.setBackground(Colori.SFONDO);

		Font fontTesto = Fonts.FONT_TESTO;
		
		String[] lettere = secondaRiga();
		
		for (int i = 0; i < lettere.length; i++) {
			JButton bottone = new JButton(lettere[i]);
			bottone.setActionCommand(lettere[i]);
			bottone.addActionListener(azioniT);
			bottone.setFont(fontTesto);
			bottoni[iBottone++] = bottone;
			panello.add(bottone);
		}
		
		return panello;
	}
	
	/**
	 * Restituisce un array di stringhe contenente le lettere della terza riga della tastiera.
	 * 
	 * @return Array di stringhe con le lettere della terza riga
	 */
	private String[] terzaRiga() {
		String[] lettere = { "Z", "X", "C", "V", "B", "N", "M" };
		return lettere;
	}
	
	/**
	 * Crea il pannello contenente i pulsanti della terza riga della tastiera.
	 * 
	 * @return Il pannello della terza riga della tastiera
	 */
	private JPanel pannelloTerzaRiga() {
		JPanel panello = new JPanel(new FlowLayout());
		panello.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panello.setBackground(Colori.SFONDO);

		Font fontTesto = Fonts.FONT_TESTO;
		
		String[] lettere = terzaRiga();
		
		for (int i = 0; i < lettere.length; i++) {
			JButton bottone = new JButton(lettere[i]);
			bottone.setActionCommand(lettere[i]);
			bottone.addActionListener(azioniT);
			bottone.setFont(fontTesto);
			bottoni[iBottone++] = bottone;
			panello.add(bottone);
		}
		
		return panello;
	}

	public JPanel getPannello() {
		return pannello;
	}
}
