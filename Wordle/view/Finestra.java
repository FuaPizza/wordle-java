/**
 * Questa classe rappresenta la finestra principale dell'applicazione Wordle.
 * Contiene sia il componente della tastiera che il componente della griglia di gioco.
 * 
 * @author 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import media.support.Sound;
import model.Colori;
import model.WordleM;

public class Finestra {
	
	private final JFrame finestra;
	
	private final ComponenteTastiera componenteTastiera;
	
	private final ComponenteGriglia componenteGriglia;
	
	private static final Sound musicaBackground = new Sound("music.wav");
	
	/**
	 * Metodo principale che avvia l'applicazione.
	 * 
	 * @param args gli argomenti della riga di comando
	 */
	public static void main(String[] args) {
		new Finestra(new WordleM());
		musicaBackground.loop(-1);
	}
	
	/**
	 * Costruttore della classe Finestra. Crea una nuova finestra di gioco.
	 * 
	 * @param model il modello di gioco WordleM
	 */
	public Finestra(WordleM model) {
		this.componenteTastiera = new ComponenteTastiera(this, model);
		int width = componenteTastiera.getPannello().getPreferredSize().width;
		this.componenteGriglia = new ComponenteGriglia(model, width);
		this.finestra = creaFinestra();
	}
	
	/**
	 * Metodo privato per la creazione della finestra di gioco.
	 * 
	 * @return la finestra di gioco creata
	 */
	private JFrame creaFinestra() {
		JFrame frame = new JFrame("Wordle-Bortoluzzi Fois");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(pannelloTitolo(), BorderLayout.NORTH);
		frame.add(componenteGriglia, BorderLayout.CENTER);
		frame.add(componenteTastiera.getPannello(), BorderLayout.SOUTH);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				musicaBackground.stop();
				System.exit(0);
			}
		});		
		
		frame.pack();
		frame.setVisible(true);
		
		return frame;
	}
	
	/**
	 * Metodo privato per la creazione del pannello del titolo della finestra.
	 * 
	 * @return il pannello del titolo della finestra
	 */
	private JPanel pannelloTitolo() {
		JPanel pannello = new JPanel();
		JLabel titolo = new JLabel("Wordle");
		titolo.setFont(Fonts.FONT_TITOLO);
		titolo.setForeground(Colori.TESTO);
		
		pannello.add(titolo);
		pannello.setBackground(Colori.SFONDO);
		
		return pannello;
	}
	
	/**
	 * Metodo per ridisegnare la componente della griglia di gioco.
	 */
	public void repaintComponenteGriglia() {
		componenteGriglia.repaint();
	}
	
	/**
	 * Restituisce la finestra di gioco.
	 * 
	 * @return la finestra di gioco
	 */
	public JFrame getFinestra() {
		return finestra;
	}
}
