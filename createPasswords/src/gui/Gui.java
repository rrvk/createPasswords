package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAppName;
	private JTextField txtUserName;
	private JTextField txtNumber;
	private JButton btnGenerate;

	/**
	 * Create the frame.
	 */
	public Gui() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Application name:");
		lblName.setBounds(10, 11, 102, 14);
		contentPane.add(lblName);
		
		txtAppName = new JTextField();
		txtAppName.setBounds(121, 11, 160, 20);
		contentPane.add(txtAppName);
		txtAppName.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(10, 39, 102, 14);
		contentPane.add(lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(121, 39, 160, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setText("1");
		txtNumber.setBounds(121, 70, 160, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(10, 70, 102, 14);
		contentPane.add(lblNumber);
		
		btnGenerate = new JButton("Generate Password");
		btnGenerate.setBounds(121, 113, 160, 23);
		contentPane.add(btnGenerate);
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
}
