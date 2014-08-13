package controler;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Controler {
	private boolean upperCase;
	private boolean lowerCase;
	private boolean numbers;
	private boolean other;
	private int length;
	private final String LETTERS="f89yrhjklarhf3q0hfslknz.sfq3r0j9q";
	
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
	
	public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

	public String getPassword(String appName, String naam, int number) {
		String password="";
		int aantal=1;
		int aantal2=1;
		// set it to lower cases
		appName=appName.toLowerCase();
		naam=naam.toLowerCase();
		for (int i = 0; i < length; i++) {
			char character = 0;
			// get the ascii code of the app name
			if (i>=appName.length()){
				character = LETTERS.charAt(aantal);
				aantal++;
			}
			else{
				character = appName.charAt(i);
			}
			int ascii = (int) character;
			// get the ascii code of the name
			if (i>=naam.length()){
				character = LETTERS.charAt(aantal2);
				aantal2++;
			}
			else{
				character = naam.charAt(i);
			}
			int ascii2 = (int) character;
			int temp = ascii+ascii2*number;
			password=password+Character.toString ((char) getNumber(temp));
			// ascii tabel 33-125
		}
		return password;
	}
	
	private int getNumber(int retn){
		// TODO CHECK RECURSIE OF FOR LOOP
		// TODO hoofdletter enz niet in het begin maar ergens in het midden, niet steeds op de zelfde plek
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

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
