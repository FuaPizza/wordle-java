/**
 * Questa classe rappresenta il componente della griglia di gioco, responsabile della visualizzazione della griglia
 * e delle caselle contenenti le lettere indovinate dall'utente.
 * 
 * @author bortoluzzi fois
 */
package view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JPanel;

import model.Casella;
import model.Colori;
import model.WordleM;

public class ComponenteGriglia extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int margineSup, margineSx, larghezzaLettera;
	
	private final Insets insets;
	
	private final Rectangle[][] griglia;
	
	private final WordleM model;

	public ComponenteGriglia(WordleM model, int larghezza) {
		this.model = model;
		this.margineSup = 0;
		this.larghezzaLettera = 64;
		this.insets = new Insets(0, 6, 6, 0);
		
		int larghezzaParola = (larghezzaLettera + insets.right) * model.getColonne();
		this.margineSx = (larghezza - larghezzaParola) / 2;
		int altezza = (larghezzaLettera + insets.bottom) * model.getRighe() + 2 * margineSup;
		
		this.setPreferredSize(new Dimension(larghezza, altezza));
		this.setBackground(Colori.SFONDO);
		this.griglia = calcolaCaselle();
	}
	
	/**
	 * Calcola e restituisce le caselle della griglia di gioco.
	 * 
	 * @return La griglia di caselle
	 */
	private Rectangle[][] calcolaCaselle(){
		Rectangle[][] griglia = new Rectangle[model.getRighe()][model.getColonne()];
		
		int x = margineSx;
		int y = margineSup;
		
		for (int riga = 0; riga < model.getRighe(); riga++) {
			for (int colonna = 0; colonna < model.getColonne(); colonna++) {
				griglia[riga][colonna] = new Rectangle(x, y, larghezzaLettera, larghezzaLettera);
				x += larghezzaLettera + insets.right;
			}
			x = margineSx;
			y += larghezzaLettera + insets.bottom;
		}
		
		return griglia;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fontTitolo = Fonts.FONT_TITOLO;
		Casella[][] grigliaWordle = model.getGrigliaWordle();
		
		for (int riga = 0; riga < griglia.length; riga++) {
			for (int colonna = 0; colonna < griglia[riga].length; colonna++) {
				Rectangle r = griglia[riga][colonna];
				Casella casella = grigliaWordle[riga][colonna];
				
				drawCasella(g2d, casella, r, fontTitolo);
				drawBordo(g2d, r);
			}
		}
	}
	
	/**
	 * Disegna il bordo di una casella.
	 * 
	 * @param g2d Il contesto grafico
	 * @param r Il rettangolo della casella
	 */
	private void drawBordo(Graphics2D g2d, Rectangle r) {
		int x = r.x + 1;
		int y = r.y + 1;
		int larghezza = r.width - 2;
		int altezza = r.height - 2;
		
		g2d.setColor(Colori.BORDI);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(x, y, x + larghezza, y);
		g2d.drawLine(x + larghezza, y, x + larghezza, y + altezza);
		g2d.drawLine(x + larghezza, y + altezza, x, y + altezza);
		g2d.drawLine(x, y, x, y + altezza);
	}
	
	/**
	 * Disegna una casella nella griglia.
	 * 
	 * @param g2d Il contesto grafico
	 * @param casella La casella da disegnare
	 * @param r Il rettangolo della casella
	 * @param font La font per il testo
	 */
	private void drawCasella(Graphics2D g2d, Casella casella, Rectangle r, Font font) {
		if (casella != null) {
			g2d.setColor(casella.getColoreBackground());
			g2d.fillRect(r.x, r.y, r.width, r.height);
			g2d.setColor(casella.getColoreTesto());
			drawStringaCentrata(g2d, Character.toString(casella.getLettera()), r, font);
		}
	}
	
	/**
	 * Disegna una stringa centrata all'interno di un rettangolo.
	 * 
	 * @param g2d Il contesto grafico
	 * @param stringa La stringa da disegnare
	 * @param r Il rettangolo in cui disegnare la stringa
	 * @param font La font per il testo
	 */
	private void drawStringaCentrata(Graphics2D g2d, String stringa, Rectangle r, Font font) {
		FontMetrics metricheFont = g2d.getFontMetrics(font);
		int x = r.x + (r.width - metricheFont.stringWidth(stringa)) / 2;
		int y = r.y + ((r.height - metricheFont.getHeight()) / 2) + metricheFont.getAscent();

		g2d.setFont(font);
		g2d.drawString(stringa, x, y);
	}
}
