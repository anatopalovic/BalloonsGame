package balloons;

import java.awt.Color;

public abstract class Kruzna_figura extends Krug {
	
	protected Vektor brzina;
	protected Scena scena;

	public Kruzna_figura(Vektor centar, double precnik, Color boja, Vektor brzina, Scena scena) {
		super(centar, precnik, boja);
		this.brzina = brzina;
		this.scena = scena;
	}
	
	public void proslo(double vreme) {
		
		pomeri(vreme);
		
		
		if(centar.getX() - precnik / 2 < 0 || centar.getX() + precnik / 2 > scena.getWidth() || centar.getY() - precnik / 2 < 0 || centar.getY() + precnik / 2 > scena.getHeight())
			scena.izbaci(this);
		
	}
	
	
	protected abstract void pomeri(double vreme);
	public abstract void sudarena(Kruzna_figura figura);
}
