package balloons;

import java.awt.Color;
import java.awt.Graphics;

public class Krug {
	
	protected Vektor centar;
	protected double precnik;
	private Color boja;
	
	
	public Krug(Vektor centar, double precnik, Color boja) {
		super();
		this.centar = centar;
		this.precnik = precnik;
		this.boja = boja;
	}
	
	public void iscrtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		
		int x = (int)centar.getX();
		int y = (int)centar.getY();
		double poluprecnik = precnik / 2;
		x -= (int)(poluprecnik / 2);
		y -= (int)(poluprecnik / 2);
		int r = (int)poluprecnik;
		g.fillOval(x, y, r, r);
		g.dispose();
	}

	public static boolean preklapa(Krug k1, Krug k2) {
		
		double razlika_x = k1.centar.getX() - k2.centar.getX();
		double razlika_y = k1.centar.getY() - k2.centar.getY();
		
		double rastojanje = Math.sqrt(Math.pow(razlika_x, 2) + Math.pow(razlika_y, 2));
		
		return rastojanje <= (k1.precnik / 2) / 2 + (k2.precnik / 2) / 2;
	}

}
