import java.util.ArrayList;

public class Polynomial {
	private ArrayList<Term> polynomial;

	public Polynomial() {
		polynomial = new ArrayList<>();
	}

	public void add(Term t) {
		if(polynomial.size() == 0) {
			polynomial.add(t);
			return;
		}
		for (int i = 0; i < polynomial.size(); i++) {
			Term term = polynomial.get(i);
			int newCoeff = 0;
			if (term.exp() == t.exp()) {
				newCoeff = term.coeff() + t.coeff();
				if (newCoeff == 0) {
					polynomial.remove(term);
				} else {
					term.setCoeff(newCoeff);
				}
				break;
			} else if (t.exp() > term.exp()) {
				polynomial.add(i, t);
				break;
			} else if ( polynomial.size() != 0 && t.exp() < polynomial.get(polynomial.size() - 1).exp()) {
				polynomial.add(t);
				break;
			} 

		}
	}
	
	public Polynomial times (Polynomial other ) {
		Polynomial newPol = new Polynomial();
		for(Term term : polynomial) {
			for(Term otherT: other.polynomial) {
				Term t = term.times(otherT);
				newPol.add(t);
				
			}
		}
		return newPol;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < polynomial.size(); i++) {
			String sign = polynomial.get(i).coeff() > 0 ? "+" : "";
			result += result.equals("") ? polynomial.get(i).toString() : sign + polynomial.get(i).toString();
		}
		return result;
	}
}
