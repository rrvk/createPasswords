package main;

import javax.swing.JFrame;

import controler.Controler;
import gui.Gui;
import handeler.Handeler;

public class Main {
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setBounds(100, 100, 450, 213);
		gui.setResizable(false);
		gui.setVisible(true);
		Controler con = new Controler();
		new Handeler(gui,con);
	}
}
