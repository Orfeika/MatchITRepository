package schedule;

import java.util.ArrayList;

public class Machine {
	private int nbr;
	private Job[] assignedJobList;

	/** Skapar maskin nr nbr. */
	public Machine(int nbr) {
		this.nbr = nbr;
		assignedJobList = assignedJobList[nbr];
	}

	/** Tar reda på maskinens nr. */
	public int getNbr() {
		return nbr;
	}

	/** Tilldelar maskinen jobbet j. */
	public void assignJob(Job j) {
		assignedJobList.add(j);
	}

	/** Tar bort alla jobb från maskinen. */
	public void clearJobs() {
		for (int i = 0; i < assignedJobList.size(); i++) {
			assignedJobList.remove(i);
		}
	}

	/**
	 * Tar bort och returnerar nästa jobb som maskinen ska utföra. Returnerar null
	 * om maskinen inte har några jobb.
	 */
	public Job getNextJob() {
		return assignedJobList.remove(assignedJobList.size() -1);
	}

	/** Tar reda på den totala tiden för maskinens jobb. */
	public int getTotalTime() {
		int sum =0; 
		for(Job job: assignedJobList) {
			sum += job.getTime();
		}
		
		return sum;
	}

	/**
	 * Returnerar en sträng som innehåller maskinens nr samt maskinens schemalagda
	 * jobb inom [] med kommatecken mellan.
	 */
	public String toString() {
		return assignedJobList.toString();
	}

}
