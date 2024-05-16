/**
 * Questa classe gestisce le azioni associate ai pulsanti della tastiera nella finestra di gioco.
 * Si occupa di interpretare gli eventi generati dai pulsanti e di aggiornare di conseguenza lo stato del gioco.
 * 
 * @author bortoluzzi fois
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Casella;
import model.Colori;
import model.WordleM;
import view.Finestra;

public class AzioniTastiera implements ActionListener {
	
	private final Finestra finestra;
	private final WordleM model;
	
	/**
	 * Costruttore della classe AzioniTastiera.
	 * 
	 * @param finestra la finestra di gioco
	 * @param model il modello di gioco WordleM
	 */
	public AzioniTastiera(Finestra finestra, WordleM model) {
		this.finestra = finestra;
		this.model = model;
	}
	
	/**
	 * Metodo che gestisce l'azione generata dal click su un pulsante della tastiera.
	 * 
	 * @param e l'evento generato dal click sul pulsante
	 */
	public void actionPerformed(ActionEvent e) {
		String testoBottone = e.getActionCommand();
		
		if (testoBottone.equals("Invio")) {
			if (model.getCurColonna() >= (model.getColonne() - 1)) {
				boolean altriTentativi = model.rivelaRiga();
				Casella[] curRiga = model.getCurRiga();
				
				int corrette = 0;
				
				for (Casella casella : curRiga) {
					if (casella != null && casella.getColoreBackground().equals(Colori.CORRETTO)) {
						corrette++;
					}
				}
				
				if (corrette >= model.getColonne()) {
					finestra.repaintComponenteGriglia();
					JOptionPane.showMessageDialog(finestra.getFinestra(), "Hai Vinto!");
					model.inizializza();
					finestra.repaintComponenteGriglia();
					
					
				} else if (!altriTentativi) {
					finestra.repaintComponenteGriglia();
					JOptionPane.showMessageDialog(finestra.getFinestra(), "Hai Perso!");
					model.inizializza();
					finestra.repaintComponenteGriglia();
				}
				else {
					finestra.repaintComponenteGriglia();
				}	
			}
		}
		else if (testoBottone.equals("Cancella")) {
			if (model.getCurColonna() >= 0) {
				model.cancellaLettera();
				finestra.repaintComponenteGriglia();		
			}
		}
		else {
			model.setLettera(testoBottone.charAt(0));
			finestra.repaintComponenteGriglia();
		}
	}

}
