package testjanuary2016;

public class StudentSurvey extends Survey{

	public static final int STIL = 0;
	public static final int NAME1 = 1;
	public static final int NAME2 = 2;
	public static final int PROGRAM = 3;
	public static final int PROGRAMMED = 4;
	public static final int LANGUAGE = 5;
	public StudentSurvey(Table data) {
	super(data);
	}
	public void printParticipants() {
	System.out.println("\nSTIL ID Namn");
	for (int row = 0; row < data.getNumberOfRows(); row++) {
	System.out.println(data.get(row, STIL) + " " +
	data.get(row, NAME2) + ", " + data.get(row, NAME1));
	}
	}
	public void printProgramStatistics() {
	System.out.println("\nVilket program går du?");
	String[] param = {"W","D"};
	printRegistration(PROGRAM, param);
	}
	public void printProgrammedStatistics() {
	System.out.println("\nHar du programmerat innan du kom till LTH?");
	String[] param = {"Ja","Nej"};
	printRegistration(PROGRAMMED, param);
	}
	public void printLanguageStatistics() {
	System.out.println("\nVilket programspråk har du använt mest?");
	String[] param = {"Java","C++"};
	printRegistration(LANGUAGE, param);
	}
	}
}
