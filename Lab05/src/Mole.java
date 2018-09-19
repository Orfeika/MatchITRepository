import java.awt.Color;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import se.lth.cs.pt.window.SimpleWindow;

public class Mole {
	private Graphics gp;

	public Mole(Graphics gp) {
		this.gp = gp;
	}

	public void dig() {
		int x = gp.getWidth() / 3; // För att börja på mitten
		int y = gp.getHeight() / 3;

		while (true) {
			System.out.println("x" + x + "y" + y);
			gp.block(x, y, Colors.MOLE);
			char key = gp.waitForKey();
			if(y<gp.getHeight() / 3) {
				Color c = y<gp.getHeight()/4?Colors.SKY:Colors.GRASS;
				gp.block(x, y, c);

			}else {
				gp.block(x, y, Colors.TUNNEL);
	
			}

			if (key == 'w') {
				y = y <gp.getHeight() / 4 ? y + 1 : y - 1;

			} else if (key == 'a') {
				x = x < 0 ? x + 1 : x - 1;

			} else if (key == 'd') {
				x = x > gp.getWidth() ? x - 1 : x + 1;
			} else if (key == 's') {
				y = y >= gp.getHeight() ? y - 1 : y + 1;

			}

		}

	}

	public void drawTheMoleWorld() {
		gp.rectangle(0, 0, gp.getWidth(), gp.getHeight() / 4, Colors.SKY);
		gp.rectangle(0, gp.getHeight() / 4, gp.getWidth(), gp.getHeight() / 3, Colors.GRASS);
		gp.rectangle(0, gp.getHeight() / 3, gp.getWidth(), gp.getHeight(), Colors.SOIL);

	}

	public static void main(String[] args) {
		System.out.println("Keep on digging!");
		Graphics g = new Graphics(70, 70, 10);
		g.waitForKey();
		Mole m = new Mole(g);
		m.drawTheMoleWorld();
		m.dig();

	}

}
