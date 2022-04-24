package balloons;


public class Vektor implements Cloneable {
	
	private double x;
	private double y;

	public Vektor(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public void pomnozi(double d) {
		x *= d;
		y *= d;
	}
	
	public void saberi(Vektor v) {
		x += v.x;
		y += v.y;
	}
	
	
	@Override
	protected Vektor clone() {
		try{
			
			Vektor v = (Vektor)super.clone();
			return v;
		
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}

	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
