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
	}

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
								// Get the length
								con.setLength(Integer.parseInt(Controler.getSelectedButtonText(gui.getGroup())));
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
