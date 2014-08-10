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
							con.getPassword(gui.getTxtAppName().getText(),gui.getTxtUserName().getText(),Integer.parseInt(gui.getTxtNumber().getText()));
						}
						else{
							System.out.println("Er is geen geldig numer ingevoerd");
						}
					}
					else{
						System.out.println("Er is geen naam ingevult");
					}
				}
				else{
					System.out.println("Er is geen application naam ingevult");
				}
				// TODO Auto-generated method stub
				
			}
		});		
	}

}
