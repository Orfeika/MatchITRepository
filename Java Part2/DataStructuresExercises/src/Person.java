
/**
 * @author an0136to
 *
 */
public class Person {
	private String familyName;
	private String givenName;

	
	/**
	 * @param per compare the person with a given person 
	 * @return if 0 persons are equal
	 */
	public int compareTo(Person per) {
		if (familyName.compareTo(per.familyName) == 0) {
			return givenName.compareTo(per.givenName);
		} else {
			return familyName.compareTo(per.familyName);
		}
	}
	
	/**
	 * @param justMarried true if they just married 
	 * @param newFamilyName change familyName
	 */
	public void changeFamilyName(boolean justMarried, String newFamilyName) {
		if(justMarried) {
			familyName = newFamilyName;
		}
		
	}

}
