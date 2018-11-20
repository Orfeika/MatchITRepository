
public class Term {
	private int coeff ;
	private int exp;
	
	public Term(int a, int b) {
		this.coeff = a;
		this.exp = b; 
	}
	
	
	public int coeff() {
		return coeff;
	}

	public void setCoeff(int a) {
		this.coeff = a;
	}
	 public int exp() {
		 return exp;
	 }
	 
	 public Term times(Term other) {
		 int newCoef  = other.coeff * this.coeff;
		 int newExp = other.exp + this.exp;
		 return new Term(newCoef, newExp); 
	 }
	 
	public  String toString() {
		String exponent = this.exp == 0?"":
			this.exp==1?"x":"x"+this.exp;
		
		 return this.coeff + exponent;
	 }

	
}
