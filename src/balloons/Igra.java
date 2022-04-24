package balloons;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame{
	
	private Scena scena;
	
	public Igra() {
		
		super("Igra");
		setBounds(200, 200, 500, 500);
		setLayout(new BorderLayout());
		
		scena = new Scena(this);
		add(scena, BorderLayout.CENTER);
		
		setVisible(true);
		scena.pokreni();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scena.zaustavi();
				dispose();
			}
		});
		
	}

	public static void main(String[] args) {
	
		
		Igra igra = new Igra();
	}

}
