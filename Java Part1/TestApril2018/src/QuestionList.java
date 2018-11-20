import java.util.ArrayList;
import java.util.Scanner;

public class QuestionList {
	ArrayList<Question> questionList;

	public QuestionList() {
		questionList = new ArrayList<>();
	}

	public void readQuestionsFromFile(String fileName) {

	}

	public void add(Question newQuestion) {

		questionList.add(newQuestion);
	}

	public Question get(int qix) {

		return questionList.get(qix);
	}

	public int getSize() {
		return questionList.size();
	}

	public double ask(int qix, Scanner scan) {

		Question q = questionList.get(qix);
		q.ask();
		String answer = scan.nextLine();
		return q.getPoints(answer.toCharArray()[0]);

	}

}
