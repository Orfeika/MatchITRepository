
public class Question {
	private String question;
	private String[] answers;
	private double[] points;

	public Question(String question, String[] answers, double[] points) {
		this.question = question;
		this.answers = answers;
		this.points = points;
	}

	public void ask() {
		System.out.println(question);
		for (int i = 0; i<answers.length; i++) {
			System.out.println(answers[i] );
		}
		
	}
	
	 public double getPoints(char answer) {
		for(int i = 0 ; i<answers.length; i++) {
			if(answers[i].toCharArray()[0] == answer ) {
				return points[i];
			}
		}
		 
		return -1;
	}
	 
	 
}
