package controler;

public class Controler {
	private boolean upperCase;
	private boolean lowerCase;
	private boolean numbers;
	private boolean other;
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    if (Integer.parseInt(s)>0)
	    	return true;
	    return false;
	}

	public String getPassword(String appName, String naam, int number) {
		String password="";
		int aantal=1;
		int aantal2=1;
		// set it to lower cases
		appName=appName.toLowerCase();
		naam=naam.toLowerCase();
		//System.out.println(appName);
		//System.out.println(naam);
		//System.out.println(number);
		int j;
		int k;
		// TODO lengte aanpassen
		for (int i = 0; i < 15; i++) {
			// get the ascii code of the app name
			if (i>=appName.length()){
				// TODO dit netter maken, niet de laatste steeds pakken maar weer opnieuw beginnen
				j=i-aantal;
				aantal++;
			}
			else{
				j=i;
			}
			char character = appName.charAt(j);
			int ascii = (int) character;
			// get the ascii code of the name
			if (i>=naam.length()){
				// TODO dit netter maken, niet de laatste steeds pakken maar weer opnieuw beginnen
				k=i-aantal2;
				aantal2++;
			}
			else{
				k=i;
			}
			character = naam.charAt(k);
			int ascii2 = (int) character;
			//System.out.println(ascii);
			//System.out.println(ascii2);
			int temp = ascii+ascii2*number;
			//System.out.println("aa"+getNumber(temp));
			//System.out.println("bb"+Character.toString ((char) getNumber(temp)));
			password=password+Character.toString ((char) getNumber(temp));
			// ascii tabel 33-125
		}
		//System.out.println(password);
		return password;
	}
	
	private int getNumber(int retn){
		// TODO CHECK RECURSIE OF FOR LOOP
		if (upperCase){
			upperCase=false;
			return getUpperCase(retn);
		}
		else if (lowerCase){
			lowerCase=false;
			return getLowerCase(retn);
		}
		else if (numbers){
			numbers=false;
			return getNumbers(retn);
		}
		else if (other){
			other=false;
			return getOther(retn);
		}
		if (retn>=33 && retn<=125)
			return retn;
		if (retn<125)
			retn+=35;
		else
			retn-=50;
		return getNumber(retn);
	}
	
	private int getOther(int retn) {
		if (retn>=33 && retn<=47){
			return retn;
		}
		if (retn>=58 && retn<=64){
			return retn;
		}
		if (retn>=91 && retn<=96){
			return retn;
		}
		if (retn>=123 && retn<=125){
			return retn;
		}
		if (retn<125)
			retn+=8;
		else
			retn-=9;
		
		return getOther(retn); 
	}

	private int getNumbers(int retn) {
		if (retn>=48 && retn<=57)
			return retn;
		if (retn<57)
			retn+=2;
		else
			retn-=3;
		return getNumbers(retn);
	}

	private int getLowerCase(int retn) {
		if (retn>=97 && retn<=122)
			return retn;
		if (retn<122)
			retn+=12;
		else
			retn-=13;
		return getLowerCase(retn);
	}

	private int getUpperCase(int retn){
		if (retn>=65 && retn<=90)
			return retn;
		if (retn<90)
			retn+=9;
		else
			retn-=12;
		return getUpperCase(retn);
	}

	/**
	 * @return the upperCase
	 */
	public boolean isUpperCase() {
		return upperCase;
	}

	/**
	 * @param upperCase the upperCase to set
	 */
	public void setUpperCase(boolean upperCase) {
		this.upperCase = upperCase;
	}

	/**
	 * @return the lowerCase
	 */
	public boolean isLowerCase() {
		return lowerCase;
	}

	/**
	 * @param lowerCase the lowerCase to set
	 */
	public void setLowerCase(boolean lowerCase) {
		this.lowerCase = lowerCase;
	}

	/**
	 * @return the numbers
	 */
	public boolean isNumbers() {
		return numbers;
	}

	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(boolean numbers) {
		this.numbers = numbers;
	}

	/**
	 * @return the other
	 */
	public boolean isOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(boolean other) {
		this.other = other;
	}
}
