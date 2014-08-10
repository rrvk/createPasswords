package controler;

import sun.security.util.Password;

public class Controler {
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}

	public String getPassword(String appName, String naam, int number) {
		String password="";
		int aantal=1;
		int aantal2=1;
		// set it to lower cases
		appName=appName.toLowerCase();
		naam=naam.toLowerCase();
		System.out.println(appName);
		System.out.println(naam);
		// TODO NUMBER >0
		System.out.println(number);
		int j;
		int k;
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
			System.out.println("aa"+getNumber(temp));
			System.out.println("bb"+Character.toString ((char) getNumber(temp)));
			password=password+"-"+Character.toString ((char) getNumber(temp));
			// ascii tabel 33-125
		}
		System.out.println(password);
		return password;
	}
	
	private int getNumber(int retn){
		// TODO CHECK RECURSIE OF FOR LOOP
		// TODO ADD OPTIONS FOR hoofdletters etc dat je die kunt kiezen dat ze er in zitten 
		if (retn>=33){
			if (retn<=125){
				return retn;
			}
			else
				retn-=50;
		}
		else
			retn+=35;
		return getNumber(retn);
	}
}
