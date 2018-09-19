import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Mole {
	private Graphics gp; 
	
	public Mole(Graphics gp) {
		this.gp = gp;
	}
	
	
	public void drawTheMoleWorld() {
		
		for (int i =1 ; i<10; i++) {
			gp.rectangle(10*i, 10*i, gp.getWidth()-20*i, 5, Colors.SOIL);
			gp.rectangle(10*i, 10*i,5,  gp.getHeight()-20*i-5, Colors.SOIL);
			gp.rectangle(gp.getWidth()-10*i+5, 10*i,5,  gp.getHeight()-20*i+5, Colors.SOIL);
			gp.rectangle(10*i, gp.getHeight()-10*i, gp.getWidth()-20*i+5, 5, Colors.SOIL);
		}
			
		
	}

	public static void main(String[] args) {
		System.out.println("Keep on digging!"); 
		Graphics g = new Graphics(200,150,5);
		Mole m = new Mole (g);
		m.drawTheMoleWorld();
		
	}

}
