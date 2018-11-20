import java.util.ArrayList;
import java.util.Set;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>(8);
		ArrayList<RaceTurtle> raceWinners = new ArrayList<RaceTurtle>(3);
		for (int i = 1; i <= 8; i++) {
			turtles.add(new RaceTurtle(w, i));

		}

		while (raceWinners.size() < 3) {
			for (int i = 0; i < turtles.size(); i++) {
				RaceTurtle t = turtles.get(i);
				if (t.getX() >= RaceWindow.X_END_POS) {

					if (!raceWinners.contains(t)) {
						raceWinners.add(t);
					}
				} else {
					t.raceStep();

				}
				RaceWindow.delay(1);
			}

		}
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + " " + raceWinners.get(i).toString());
		}

	}

}
