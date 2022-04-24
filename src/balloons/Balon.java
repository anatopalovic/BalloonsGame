package balloons;

import java.awt.Color;
import java.awt.Graphics;

public class Balon extends Kruzna_figura {

	public Balon(Vektor centar, double precnik, Color boja, Vektor brzina, Scena scena) {
		super(centar, precnik, boja, brzina, scena);
	}

	@Override
	public void pomeri(double vreme) {
	
		double put = vreme * 0.001 * brzina.getY();
	
		centar.saberi(new Vektor(0, put));
		
	}

	@Override
	public void sudarena(Kruzna_figura figura) {}
	


}
