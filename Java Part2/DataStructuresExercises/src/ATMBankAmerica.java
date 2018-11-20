
public class ATMBankAmerica {
	private String pin; 
	
	public boolean verifyPIN(String gPin) {
		return (pin.compareTo(gPin) == 0);
		
	}
}
