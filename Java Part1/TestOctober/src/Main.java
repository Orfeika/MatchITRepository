
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import assess.Applicant;
import assess.SetUtilities;
import assess.TestResult;

public class Main {
	public static void main(String[] args) {
		// ArrayList<Applicant> applicants = 
		// FileReader.readFromFile("testresults");

		// For the purpose of the test, students could assume that ArrayList
		// applicants is created by an implemented method FileReader.readFromFile("testresults")
		// In order to produce a running program, without having to implement the method, I have
		// created 5 test results and corresponding 5 applicants
		TestResult test1 = new TestResult(new int[] { 5, 3, 4, 2, 1 }); // 15:5
																		// = 3
		TestResult test2 = new TestResult(new int[] { 5, 3, 4, 2, 5 }); // 19:5
																		// = 3.8
		TestResult test3 = new TestResult(new int[] { 5, 3, 4, 2, 4 }); // 18:
																		// 5=
																		// 3.6
		TestResult test4 = new TestResult(new int[] { 5, 3, 4, 2, 3 }); // 17:5
																		// = 3.4
		TestResult test5 = new TestResult(new int[] { 5, 3, 4, 2, 2 }); // 16:5=
																		// 3.2

		Applicant applicant1 = new Applicant("Person1", 1, test1);
		Applicant applicant2 = new Applicant("Person2", 2, test2);
		Applicant applicant3 = new Applicant("Person3", 3, test3);
		Applicant applicant4 = new Applicant("Person4", 4, test4);
		Applicant applicant5 = new Applicant("Person5", 5, test5);

		
        // I create an instance of ApplicantSelector class by using the test results and applicants
		// I have isntantiated explicitly above instead of the following code:
		// ApplicantSelector selector = new ApplicantSelector(applicants);
		ApplicantSelector1 selector = new ApplicantSelector1(
				new ArrayList<Applicant>(Arrays.asList(applicant1, applicant2, applicant3, applicant4, applicant5)));

		ArrayList<Integer> testList = selector.getBestMean(2);
		
	}}

