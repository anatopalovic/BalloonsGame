package balloons;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;


public class Scena extends Canvas implements Runnable {
	
	private Igra igra;
	private Thread nit;
	private LinkedList<Kruzna_figura> figure;
	private LinkedList<Kruzna_figura> izbacivanje;
	private Igrac igrac;

	public Scena(Igra igra) {
		this.igra = igra;
		figure = new LinkedList<Kruzna_figura>();
		izbacivanje = new LinkedList<Kruzna_figura>();
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP: {
				}
				case KeyEvent.VK_DOWN: {
					break;
				}
				case KeyEvent.VK_LEFT: {
					igrac.pomeri_horizontalno(-10);
					break;
				}
				case KeyEvent.VK_RIGHT: {
					igrac.pomeri_horizontalno(10);
					break;
				}
				}
			}
		});
		
	}

	@Override
	public void run() {
		
		while(!Thread.interrupted()) {
			try {
				
				Thread.sleep(60);
				
				odradi();
				
				repaint();
				
			}catch(InterruptedException e) {
				nit.interrupt();
			}
		}

	}

	private synchronized void odradi() {
		
		
		double random = Math.random();
		if(random <= 0.1)
			figure.add(new Balon(new Vektor((Math.random() * getWidth()), 10), 20, Color.RED, new Vektor(0, 100), this));
		
		for(Kruzna_figura f : figure)
			f.proslo(60);
		
		
		Iterator<Kruzna_figura> iterator = figure.iterator();
		while(iterator.hasNext()) {
			for(Kruzna_figura f : izbacivanje)
				if(iterator.next() == f) {
					iterator.remove();
				}
			break;
		}
		
		while(!izbacivanje.isEmpty())
			izbacivanje.remove();
		
		
		for(Kruzna_figura f1 : figure)
			for(Kruzna_figura f2 : figure)
				if(f1 != f2)
					if(Krug.preklapa(f1, f2)) {
						f1.sudarena(f2);
						f2.sudarena(f1);
					}
	}

	public void pokreni() {
		
		nit = new Thread(this);
		igrac = new Igrac(new Vektor(getWidth() / 2, getHeight() * (0.9)), 30, Color.GREEN, new Vektor(10,10), this);
		figure.add(igrac);
		
		nit.start();
		requestFocus();
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(Kruzna_figura f : figure)
			f.iscrtaj(this);
		
		g.clearRect(0, getHeight() - 10, getWidth(), 20);
	}

	public void zaustavi() {
		
		nit.interrupt();
		
	}

	public synchronized void izbaci(Kruzna_figura figura) {
		izbacivanje.add(figura);
	}
	
	public void dodaj(Kruzna_figura figura) {
		figure.add(figura);
	}

}
