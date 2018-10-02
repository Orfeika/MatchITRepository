package polygon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import se.lth.cs.pt.window.SimpleWindow;

public class ManyPolygons {

	public static void main(String[] args) {
		Scanner scan = null;
		Scanner scanLine = null;
		SimpleWindow w = new SimpleWindow(600, 600, "A polygon");
		Polygon polygon= null;

		try {
			scan = new Scanner(new File("polygon2"));

		} catch (FileNotFoundException e) {
			System.out.println("No file exist in directory " + System.getProperty("user.dir"));
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			  Polygon pol = new Polygon();
			  
			 scanLine = new Scanner(scan.nextLine());			
			while (scanLine.hasNextInt()) {
				int x = scanLine.nextInt();
				System.out.println("x " + x);
				int y = scanLine.nextInt();
				System.out.println("y " + y);
				pol.addVertex(x, y);
			}
			
			polygon = new Polygon(pol.getVertexCounter());
			 polygon.setPolygonCoordinates( Arrays.copyOfRange
					(pol.getPolygonCoordinates(),0,pol.getVertexCounter()));
			polygon.draw(w);
		}
		scan.close();
		scanLine.close();
	}

}
