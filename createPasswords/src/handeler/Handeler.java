package handeler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Gui;
import controler.Controler;

public class Handeler {
	Gui gui;
	Controler con;
	public Handeler(Gui gui, Controler con) {
		this.gui=gui;
		this.con=con;
		addControler();
		//addMenuControler();
	}
	
	/*private void addMenuControler() {
		gui.getCbMenuUppercase().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED){
					con.setUpperCase(true);
				}
				else{
					con.setUpperCase(false);
				}		
			}
		});
		
		gui.getCbMenuLowercase().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED){
					con.setLowerCase(true);
				}
				else{
					con.setLowerCase(false);
				}		
			}
		});
		
		gui.getCbMenuNumbers().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED){
					con.setNumbers(true);
				}
				else{
					con.setNumbers(false);
				}		
			}
		});
		
		gui.getCbMenuOther().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED){
					con.setOther(true);
				}
				else{
					con.setOther(false);
				}		
			}
		});
	}*/

	private void addControler() {
		gui.getBtnGenerate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!gui.getTxtAppName().getText().isEmpty()){
					if (!gui.getTxtUserName().getText().isEmpty()){
						if (!gui.getTxtNumber().getText().isEmpty() && Controler.isInteger(gui.getTxtNumber().getText())){
							if (Integer.parseInt(gui.getTxtNumber().getText())<1000){
								// Check options
								con.setLowerCase(gui.getCbMenuLowercase().getState());
								con.setNumbers(gui.getCbMenuNumbers().getState());
								con.setOther(gui.getCbMenuOther().getState());
								con.setUpperCase(gui.getCbMenuUppercase().getState());
								// Get the password
								String password = con.getPassword(gui.getTxtAppName().getText(),gui.getTxtUserName().getText(),Integer.parseInt(gui.getTxtNumber().getText()));
								gui.getTxtPassword().setText(password);
							}
							else{
								// TODO uitzoeken hoehoog die kan
								System.out.println("Het numer is te groot, wanneer dit hoger moet worden vraag de ontwikkelaar");
							}
						}
						else{
							// TODO EXEPTION EN POPUP
							System.out.println("Er is geen geldig numer ingevoerd");
						}
					}
					else{
						// TODO EXEPTION EN POPUP
						System.out.println("Er is geen naam ingevult");
					}
				}
				else{
					// TODO EXEPTION EN POPUP
					System.out.println("Er is geen application naam ingevult");
				}				
			}
		});			
	}
}
