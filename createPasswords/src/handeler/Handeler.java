package handeler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.Gui;
import controler.Controler;
import controler.Write;

public class Handeler {
	Gui gui;
	Controler con;
	public Handeler(Gui gui, Controler con) {
		this.gui=gui;
		this.con=con;
		addControler();
	}

	/**
	 * This first cleans the recent box then updat it
	 */
	private void updateListBox(){
		Write w = new Write();
		String [][] lines = null;
		gui.getRecentModel().removeAllElements();
		try {
			lines=w.getAllSettingsFromFile();
			con.setRecords(lines);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IO Error "+e.getMessage());
		}
		for (int i = 0; i < lines.length; i++) {
			gui.getRecentModel().addElement(lines[i][0]+" "+lines[i][1]);
		}
	}
	
	private String getPassword(boolean lower,boolean num,boolean other,boolean upper,int lengt){
		con.setLowerCase(lower);
		con.setNumbers(num);
		con.setOther(other);
		con.setUpperCase(upper);
		// Get the length
		con.setLength(lengt);
		// Get the password
		return con.getPassword(gui.getTxtAppName().getText(),gui.getTxtUserName().getText(),Integer.parseInt(gui.getTxtNumber().getText()));
	}
	
	/**
	 * This add all the action listeners
	 */
	private void addControler() {
		gui.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent arg0) {
				updateListBox();				
			}			
			public void windowIconified(WindowEvent arg0) {}
			public void windowDeiconified(WindowEvent arg0) {}
			public void windowDeactivated(WindowEvent arg0) {}
			public void windowClosing(WindowEvent arg0) {}
			public void windowClosed(WindowEvent arg0) {}
			public void windowActivated(WindowEvent arg0) {}
		});
		
		gui.getRecent().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				int number = gui.getRecent().getSelectedIndex();
				if (number!=-1){
					String[][] record = con.getRecords();
					gui.getTxtAppName().setText(record[number][0]);
					gui.getTxtUserName().setText(record[number][1]);
					boolean upper;
					if (record[number][2].equals("1"))
						upper=true;
					else
						upper=false;
					gui.getCbMenuUppercase().setSelected(upper);
					boolean lower;
					if (record[number][3].equals("1"))
						lower=true;
					else
						lower=false;
					gui.getCbMenuLowercase().setSelected(lower);
					boolean num;
					if (record[number][4].equals("1"))
						num=true;
					else
						num=false;
					gui.getCbMenuNumbers().setSelected(num);
					boolean other;
					if (record[number][5].equals("1"))
						other=true;
					else
						other=false;
					gui.getCbMenuOther().setSelected(other);
					int lengt = Integer.parseInt(record[number][6]);
					// set the lengt button
					for (Enumeration<AbstractButton> buttons = gui.getGroup().getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();

			            if (button.getText().equals(record[number][6])) {
			                button.setSelected(true);
			            }
			        }
					gui.getTxtPassword().setText(getPassword(lower,num,other,upper,lengt));
				}
			}
		});
		
		gui.getBtnGenerate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!gui.getTxtAppName().getText().isEmpty()){
					if (!gui.getTxtUserName().getText().isEmpty()){
						if (!gui.getTxtNumber().getText().isEmpty() && Controler.isInteger(gui.getTxtNumber().getText())){
							if (Integer.parseInt(gui.getTxtNumber().getText())<1000){
								Write w = new Write();
								w.setAppName(gui.getTxtAppName().getText());
								w.setLength(Integer.parseInt(Controler.getSelectedButtonText(gui.getGroup())));
								w.setLowerCase(gui.getCbMenuLowercase().getState());
								w.setNumbers(gui.getCbMenuNumbers().getState());
								w.setOther(gui.getCbMenuOther().getState());
								w.setUpperCase(gui.getCbMenuUppercase().getState());
								w.setUserName(gui.getTxtUserName().getText());
								w.setCount(Integer.parseInt(gui.getTxtNumber().getText()));
								try {
									w.addLine();
								} catch (IOException e) {
									JOptionPane.showMessageDialog(null, "IO Error "+e.getMessage());
								}
								// Check options
								gui.getTxtPassword().setText(getPassword(gui.getCbMenuLowercase().getState(),gui.getCbMenuNumbers().getState(),gui.getCbMenuOther().getState(),gui.getCbMenuUppercase().getState(),Integer.parseInt(Controler.getSelectedButtonText(gui.getGroup()))));
								updateListBox();
							}
							else{
								// TODO uitzoeken hoehoog die kan
								JOptionPane.showMessageDialog(null,"Het numer is te groot, wanneer dit hoger moet worden vraag de ontwikkelaar");
							}
						}
						else{
							JOptionPane.showMessageDialog(null,"Er is geen geldig numer ingevoerd");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Er is geen naam ingevult");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Er is geen application naam ingevult");
				}				
			}
		});			
	}
}
