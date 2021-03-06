package controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Write {
	private String appName;
	private String userName;
	private boolean upperCase;
	private boolean lowerCase;
	private boolean numbers;
	private boolean other;
	private int length;
	private int count;
	private final String FILENAME="conf.txt";
	
	private String createLine(){
		return appName+";"+userName+";"+booleanToNum(upperCase)+";"+booleanToNum(lowerCase)+";"+booleanToNum(numbers)+";"+booleanToNum(other)+";"+length+";"+count;
	}
	
	private int booleanToNum(boolean check){
		if (check)
			return 1;
		return 0;
	}
	
	public boolean addLine() throws IOException{
		String line = createLine();
		testAndCreateFile();
		String file = getSettingsFromeFile(line.split(";")[0],line.split(";")[1]);
		if (file!=null){
			if (file.equals(line)){
				return true;
			}
			deleteSettingsFromeFile(line.split(";")[0],line.split(";")[1]);
		}
		addSettingsFromeFile(line);
		return true;
	}
	
	// appname;hoofdletters;kleineletters;nummers;andere;lengte
	private void testAndCreateFile() throws IOException{
		File f = new File(FILENAME);
        f.createNewFile();
	}
	
	private void addSettingsFromeFile(String settingLine) throws IOException{
		String test[] = settingLine.split(";");
		if (test.length==8){
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME, true)));
			out.println(settingLine);
			out.close();
		}
		else{
			JOptionPane.showMessageDialog(null, "Instellingen bestand niet goed");
		}
		
	}
	
	public String[][] getAllSettingsFromFile() throws IOException{
		testAndCreateFile();
		String[][] result = new String[countLines()][7];
		int i=0;
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String line;
		while ((line = br.readLine()) != null) {
			String[] test = line.split(";");
			if (test.length > 7 &&
					test[0]!=null && test[1]!=null && test[2]!=null && test[3]!=null && test[4]!=null && test[5]!=null && test[6]!=null&& test[7]!=null){
				result[i]=test;
				i++;
			}
			else{
				System.out.println("line "+line+" is not correct");
			}
		}
		br.close();
		return result;
	}
	
	private String getSettingsFromeFile(String siteName, String gebName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String line;
		while ((line = br.readLine()) != null) {
			String[] test = line.split(";");
			if (test[0].equals(siteName) && test[1].equals(gebName)){
				br.close();
				return line;
			}
		}
		br.close();
		return null;
	}
	
	private void deleteSettingsFromeFile(String siteName, String gebName) throws IOException{
		try {

		      File inFile = new File(FILENAME);

		      if (!inFile.isFile()) {
		        System.out.println("Parameter is not an existing file");
		        return;
		      }

		      //Construct the new file that will later be renamed to the original filename.
		      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

		      BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		      String line = null;

		      //Read from the original file and write to the new
		      //unless content matches data to be removed.
		      while ((line = br.readLine()) != null) {

		        if (!line.trim().equals(getSettingsFromeFile(siteName,gebName))) {

		          pw.println(line);
		          pw.flush();
		        }
		      }
		      pw.close();
		      br.close();

		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete file");
		        return;
		      }

		      //Rename the new file to the filename the original file had.
		      if (!tempFile.renameTo(inFile))
		        System.out.println("Could not rename file");

		    }
		    catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		    catch (IOException ex) {
		      ex.printStackTrace();
		    }
	}
	
	private int countLines() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		return lines;
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

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
