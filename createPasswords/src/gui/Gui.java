package gui;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAppName;
	private JTextField txtUserName;
	private JTextField txtNumber;
	private JButton btnGenerate;
	private JCheckBoxMenuItem cbMenuLowercase, cbMenuUppercase, cbMenuNumbers,cbMenuOther;
	private JTextField txtPassword;

	/**
	 * Create the frame.
	 */
	public Gui() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Application name:");
		lblName.setBounds(10, 14, 102, 14);
		contentPane.add(lblName);
		
		txtAppName = new JTextField();
		txtAppName.setBounds(121, 11, 160, 20);
		contentPane.add(txtAppName);
		txtAppName.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(10, 39, 102, 14);
		contentPane.add(lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(121, 36, 160, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setText("1");
		txtNumber.setBounds(121, 61, 160, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(10, 64, 102, 14);
		contentPane.add(lblNumber);
		
		btnGenerate = new JButton("Generate Password");
		btnGenerate.setBounds(121, 117, 160, 23);
		contentPane.add(btnGenerate);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 89, 102, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(121, 86, 160, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Options");
		menu.setMnemonic(KeyEvent.VK_O);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This is the menu of the options");
		menuBar.add(menu);

//		//a group of JMenuItems
//		menuItem = new JMenuItem("A text-only menu item",
//		                         KeyEvent.VK_T);
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
//		menuItem.getAccessibleContext().setAccessibleDescription(
//		        "This doesn't really do anything");
//		menu.add(menuItem);
//
//		menuItem = new JMenuItem("Both text and icon",
//		                         new ImageIcon("images/middle.gif"));
//		menuItem.setMnemonic(KeyEvent.VK_B);
//		menu.add(menuItem);
//
//		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
//		menuItem.setMnemonic(KeyEvent.VK_D);
//		menu.add(menuItem);
//
//		//a group of radio button menu items
//		menu.addSeparator();
//		ButtonGroup group = new ButtonGroup();
//		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
//		rbMenuItem.setSelected(true);
//		rbMenuItem.setMnemonic(KeyEvent.VK_R);
//		group.add(rbMenuItem);
//		menu.add(rbMenuItem);
//
//		rbMenuItem = new JRadioButtonMenuItem("Another one");
//		rbMenuItem.setMnemonic(KeyEvent.VK_O);
//		group.add(rbMenuItem);
//		menu.add(rbMenuItem);

		//a group of check box menu items
		//menu.addSeparator();
		cbMenuUppercase = new JCheckBoxMenuItem("Uppercase");
		cbMenuUppercase.setMnemonic(KeyEvent.VK_U);
		menu.add(cbMenuUppercase);

		cbMenuLowercase = new JCheckBoxMenuItem("Lowercase");
		cbMenuLowercase.setMnemonic(KeyEvent.VK_L);
		menu.add(cbMenuLowercase);
		
		cbMenuNumbers = new JCheckBoxMenuItem("Numbers");
		cbMenuNumbers.setMnemonic(KeyEvent.VK_N);
		menu.add(cbMenuNumbers);
		
		cbMenuOther = new JCheckBoxMenuItem("Other characters");
		cbMenuOther.setMnemonic(KeyEvent.VK_T);
		menu.add(cbMenuOther);

//		//a submenu
//		menu.addSeparator();
//		submenu = new JMenu("A submenu");
//		submenu.setMnemonic(KeyEvent.VK_S);
//
//		menuItem = new JMenuItem("An item in the submenu");
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
//		submenu.add(menuItem);
//
//		menuItem = new JMenuItem("Another item");
//		submenu.add(menuItem);
//		menu.add(submenu);

//		//Build second menu in the menu bar.
//		menu = new JMenu("Another Menu");
//		menu.setMnemonic(KeyEvent.VK_N);
//		menu.getAccessibleContext().setAccessibleDescription(
//		        "This menu does nothing");
//		menuBar.add(menu);

		this.setJMenuBar(menuBar);
		
		
	}

	/**
	 * @return the txtAppName
	 */
	public JTextField getTxtAppName() {
		return txtAppName;
	}

	/**
	 * @param txtAppName the txtAppName to set
	 */
	public void setTxtAppName(JTextField txtAppName) {
		this.txtAppName = txtAppName;
	}

	/**
	 * @return the txtUserName
	 */
	public JTextField getTxtUserName() {
		return txtUserName;
	}

	/**
	 * @param txtUserName the txtUserName to set
	 */
	public void setTxtUserName(JTextField txtUserName) {
		this.txtUserName = txtUserName;
	}

	/**
	 * @return the txtNumber
	 */
	public JTextField getTxtNumber() {
		return txtNumber;
	}

	/**
	 * @param txtNumber the txtNumber to set
	 */
	public void setTxtNumber(JTextField txtNumber) {
		this.txtNumber = txtNumber;
	}

	/**
	 * @return the btnGenerate
	 */
	public JButton getBtnGenerate() {
		return btnGenerate;
	}

	/**
	 * @param btnGenerate the btnGenerate to set
	 */
	public void setBtnGenerate(JButton btnGenerate) {
		this.btnGenerate = btnGenerate;
	}


	/**
	 * @return the cbMenuLowercase
	 */
	public JCheckBoxMenuItem getCbMenuLowercase() {
		return cbMenuLowercase;
	}

	/**
	 * @param cbMenuLowercase the cbMenuLowercase to set
	 */
	public void setCbMenuLowercase(JCheckBoxMenuItem cbMenuLowercase) {
		this.cbMenuLowercase = cbMenuLowercase;
	}

	/**
	 * @return the cbMenuUppercase
	 */
	public JCheckBoxMenuItem getCbMenuUppercase() {
		return cbMenuUppercase;
	}

	/**
	 * @param cbMenuUppercase the cbMenuUppercase to set
	 */
	public void setCbMenuUppercase(JCheckBoxMenuItem cbMenuUppercase) {
		this.cbMenuUppercase = cbMenuUppercase;
	}

	/**
	 * @return the cbMenuNumbers
	 */
	public JCheckBoxMenuItem getCbMenuNumbers() {
		return cbMenuNumbers;
	}

	/**
	 * @param cbMenuNumbers the cbMenuNumbers to set
	 */
	public void setCbMenuNumbers(JCheckBoxMenuItem cbMenuNumbers) {
		this.cbMenuNumbers = cbMenuNumbers;
	}

	/**
	 * @return the cbMenuOther
	 */
	public JCheckBoxMenuItem getCbMenuOther() {
		return cbMenuOther;
	}

	/**
	 * @param cbMenuOther the cbMenuOther to set
	 */
	public void setCbMenuOther(JCheckBoxMenuItem cbMenuOther) {
		this.cbMenuOther = cbMenuOther;
	}

	/**
	 * @return the txtPassword
	 */
	public JTextField getTxtPassword() {
		return txtPassword;
	}

	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}
}
