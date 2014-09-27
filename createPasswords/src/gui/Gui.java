package gui;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAppName;
	private JTextField txtUserName;
	private JTextField txtNumber;
	private JButton btnGenerate;
	private JCheckBoxMenuItem cbMenuLowercase, cbMenuUppercase, cbMenuNumbers,cbMenuOther;
	private JRadioButtonMenuItem rb6,rb8,rb10,rb12,rb14,rb16;
	private JTextField txtPassword;
	private ButtonGroup group;
	private DefaultListModel<String> recentModel;
	private JList<String> recent;
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 14, 128, 130);
		contentPane.add(scrollPane);
		
		recentModel= new DefaultListModel<String>();
		recent = new JList<String>(recentModel);
		scrollPane.setViewportView(recent);
		
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

		//a group of check box menu items
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

		// make the sub menu for length
		menu.addSeparator();
		JMenu submenu = new JMenu("Password length");
		submenu.setMnemonic(KeyEvent.VK_P);
		
		group = new ButtonGroup();
		rb6 = new JRadioButtonMenuItem("6");
		rb8 = new JRadioButtonMenuItem("8");
		rb10 = new JRadioButtonMenuItem("10");
		rb10.setSelected(true);
		rb12 = new JRadioButtonMenuItem("12");
		rb14 = new JRadioButtonMenuItem("14");
		rb16 = new JRadioButtonMenuItem("16");
		group.add(rb6);
		group.add(rb8);
		group.add(rb10);
		group.add(rb12);
		group.add(rb14);
		group.add(rb16);
		submenu.add(rb6);
		submenu.add(rb8);
		submenu.add(rb10);
		submenu.add(rb12);
		submenu.add(rb14);
		submenu.add(rb16);

		menu.add(submenu);
		this.setJMenuBar(menuBar);	
	}

	/**
	 * @return the txtAppName
	 */
	public JTextField getTxtAppName() {
		return txtAppName;
	}

	/**
	 * @return the txtUserName
	 */
	public JTextField getTxtUserName() {
		return txtUserName;
	}

	/**
	 * @return the txtNumber
	 */
	public JTextField getTxtNumber() {
		return txtNumber;
	}

	/**
	 * @return the btnGenerate
	 */
	public JButton getBtnGenerate() {
		return btnGenerate;
	}

	/**
	 * @return the cbMenuLowercase
	 */
	public JCheckBoxMenuItem getCbMenuLowercase() {
		return cbMenuLowercase;
	}

	/**
	 * @return the cbMenuUppercase
	 */
	public JCheckBoxMenuItem getCbMenuUppercase() {
		return cbMenuUppercase;
	}

	/**
	 * @return the cbMenuNumbers
	 */
	public JCheckBoxMenuItem getCbMenuNumbers() {
		return cbMenuNumbers;
	}

	/**
	 * @return the cbMenuOther
	 */
	public JCheckBoxMenuItem getCbMenuOther() {
		return cbMenuOther;
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

	/**
	 * @return the group
	 */
	public ButtonGroup getGroup() {
		return group;
	}

	/**
	 * @return the recentModel
	 */
	public DefaultListModel<String> getRecentModel() {
		return recentModel;
	}

	/**
	 * @param recentModel the recentModel to set
	 */
	public void setRecentModel(DefaultListModel<String> recentModel) {
		this.recentModel = recentModel;
	}

	/**
	 * @return the recent
	 */
	public JList<String> getRecent() {
		return recent;
	}

	/**
	 * @param recent the recent to set
	 */
	public void setRecent(JList<String> recent) {
		this.recent = recent;
	}
}
