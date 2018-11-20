
import java.util.ArrayList;

import assess.Applicant;

public class ApplicantSelector1 {
	private ArrayList<Applicant> applicants;

	/**
	 * Creates an object that can select applicants from the list of applicants.
	 */
	public ApplicantSelector1(ArrayList<Applicant> applicants) {
		this.applicants = applicants;
	}

	/**
	 * Returns a list of id numbers for the specified number of applicants (nbr)
	 * who have the highest average/mean in their test results. If nbr is higher
	 * than the number of applicants, the list returned must contain ID numbers
	 * of all applicants’.
	 */
	public ArrayList<Integer> getBestMean(int nbr) {
		System.out.println(applicants.toString());

		for (int i = 0; i < applicants.size(); i++) {
			Applicant min = applicants.remove(i);
			for (int j = 0 ;j<applicants.size();j++) {
				if (min.mean()>applicants.get(j).mean()) {
					Applicant appl = applicants.remove(j);
					applicants.set(j, min);
					min =appl;
				}
				applicants.add(min);
		}

									// list
		}
		
		System.out.println(applicants.toString());
		ArrayList<Integer> selected = new ArrayList<>();
		for(int i = 0 ; i<nbr; i++) {
			int id = applicants.get(i).getId();
			selected.add(id);
			
		}
		return selected;
	}

	private int getBestMeanIndex(ArrayList<Applicant> list) {
		double max = -Double.MAX_VALUE;
		int maxPos = -1;
		for (int i = 0; i < list.size(); i++) {
			double mean = list.get(i).mean();
			if (mean > max) {
				max = mean;
				maxPos = i;
			}
		}
		return maxPos;
	}

}
