package testjanuary2016;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<String> lines =readLinesFromFile("data.csv");
//		Table input = new Table(lines, ",");
//		StudentSurvey survey = new StudentSurvey(input);
//		StudentSurvey surveyD = new StudentSurvey(input.filter(StudentSurvey.PROGRAM, "D"));
//		StudentSurvey surveyW = new StudentSurvey(input.filter(StudentSurvey.PROGRAM, "W"));
//		StudentSurvey surveyYes = new StudentSurvey(input.filter(StudentSurvey.PROGRAMMED, "Ja"));
//		System.out.println("*** ALLA ***");
//		survey.printProgramStatistics();
//		survey.printProgrammedStatistics();
//		surveyYes.printLanguageStatistics();
//		System.out.println("\n*** W-programmet ***");
//		surveyW.printParticipants();
//		surveyW.printProgrammedStatistics();
//		System.out.println("\n*** D-programmet ***");
//		surveyD.printParticipants();
//		surveyD.printProgrammedStatistics();
//		
		
		int [] reg = new int [12]; 
		
		for(int v  = 0 ; v<3; v++ ) {
			System.out.println( "!" + reg[v]);
			reg[v] = reg[v]+1;
			System.out.println(reg[v]);
				
			}
		
	}


}
