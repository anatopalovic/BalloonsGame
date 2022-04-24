package balloons;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Kruzna_figura {

	public Igrac(Vektor centar, double poluprecnik, Color boja, Vektor brzina, Scena scena) {
		super(centar, poluprecnik, Color.GREEN, brzina, scena);
	}

	@Override
	public void pomeri(double vreme) {}

	@Override
	public void sudarena(Kruzna_figura figura) {
		if(figura instanceof Balon)
			scena.zaustavi();
	}
	
	public void pomeri_horizontalno(double pomeraj) {
		
		if(centar.getX() - precnik / 2 + pomeraj < 0 || centar.getX() + precnik / 2 + pomeraj > scena.getWidth())
			return;
		
		centar.saberi(new Vektor(pomeraj, 0));
	}
	
	@Override
	public void iscrtaj(Scena scena) {
		
		super.iscrtaj(scena);
		
		Graphics g = scena.getGraphics();
		g.setColor(Color.BLUE);
		int x = (int)centar.getX();
		int y = (int)centar.getY();
		double poluprecnik = precnik / 2;
		double novi = poluprecnik / 2;
		x -= (int)(novi / 2);
		y -= (int)(novi / 2);
		int r = (int)(novi);
		g.fillOval(x, y, r, r);
		g.dispose();
		
	}

}
