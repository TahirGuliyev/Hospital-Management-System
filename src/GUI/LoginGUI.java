package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.HeadDoctor;
import Util.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel wPane;
	private JTextField txtPacientFinKod;
	private JTextField txtDoctorFinKod;
	private JPasswordField txtDoctorPassword;
	private JPasswordField txtPacientPassword;
	private DBConnection conn = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		setResizable(false);
		setTitle("X\u0259st\u0259xana \u0130dar\u0259etm\u0259 Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		wPane = new JPanel();
		wPane.setBackground(new Color(224, 255, 255));
		wPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wPane);
		wPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(new ImageIcon(getClass().getResource("medicine.jpg")));
		lblLogo.setBounds(297, 13, 98, 80);
		wPane.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("X\u018FST\u018FXANA \u0130DAR\u018FETM\u018F S\u0130STEM\u0130N\u018F XO\u015E G\u018FLM\u0130S\u0130N\u0130Z!..");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(38, 115, 617, 26);
		wPane.add(lblNewLabel);
		
		JTabbedPane wTabpane = new JTabbedPane(JTabbedPane.TOP);
		wTabpane.setBackground(new Color(224, 255, 255));
		wTabpane.setBounds(10, 159, 662, 340);
		wPane.add(wTabpane);
		
		JPanel wPacientLogin = new JPanel();
		wPacientLogin.setBackground(new Color(224, 255, 255));
		wTabpane.addTab("Pasient Login", null, wPacientLogin, null);
		wPacientLogin.setLayout(null);
		
		JLabel lblPasientFinKod = new JLabel("F\u0130N KOD :");
		lblPasientFinKod.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPasientFinKod.setBounds(129, 54, 114, 26);
		wPacientLogin.add(lblPasientFinKod);
		
		JLabel lblPacientPassword = new JLabel("\u015E\u0130FR\u018F :");
		lblPacientPassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPacientPassword.setBounds(129, 116, 114, 26);
		wPacientLogin.add(lblPacientPassword);
		
		txtPacientFinKod = new JTextField();
		txtPacientFinKod.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPacientFinKod.setBounds(285, 48, 236, 36);
		wPacientLogin.add(txtPacientFinKod);
		txtPacientFinKod.setColumns(10);
		
		JButton btnPacientRegister = new JButton("QEYD\u0130YYAT");
		btnPacientRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPacientRegister.setBackground(new Color(30, 144, 255));
		btnPacientRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPacientRegister.setBounds(129, 198, 147, 55);
		wPacientLogin.add(btnPacientRegister);
		
		JButton btnPacientEnter = new JButton("DAX\u0130L OL");
		btnPacientEnter.setBackground(new Color(50, 205, 50));
		btnPacientEnter.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPacientEnter.setBounds(374, 198, 147, 55);
		wPacientLogin.add(btnPacientEnter);
		
		txtPacientPassword = new JPasswordField();
		txtPacientPassword.setBounds(285, 115, 236, 36);
		wPacientLogin.add(txtPacientPassword);
		
		JPanel wDoctorLogin = new JPanel();
		wDoctorLogin.setBackground(new Color(224, 255, 255));
		wTabpane.addTab("Həkim Login", null, wDoctorLogin, null);
		wDoctorLogin.setLayout(null);
		
		JLabel lblDoctorFinKod = new JLabel("FİN KOD :");
		lblDoctorFinKod.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDoctorFinKod.setBounds(130, 53, 114, 26);
		wDoctorLogin.add(lblDoctorFinKod);
		
		txtDoctorFinKod = new JTextField();
		txtDoctorFinKod.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDoctorFinKod.setColumns(10);
		txtDoctorFinKod.setBounds(286, 47, 236, 36);
		wDoctorLogin.add(txtDoctorFinKod);
		
		JLabel lblDoctorPassword = new JLabel("ŞİFRƏ :");
		lblDoctorPassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDoctorPassword.setBounds(130, 115, 114, 26);
		wDoctorLogin.add(lblDoctorPassword);
		
		JButton btnDoctorEnter = new JButton("DAXİL OL");
		btnDoctorEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDoctorPassword.getText().length() == 0 || txtDoctorFinKod.getText().length() == 0) {
					Util.Helper.showMsg("fill");
				} else {
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if(txtDoctorFinKod.getText().equals(rs.getString("finkod")) && txtDoctorPassword.getText().equals(rs.getString("password"))) {
								HeadDoctor headDoc = new HeadDoctor();
								headDoc.setId(rs.getInt("id"));
								headDoc.setFinKod(rs.getString("finkod"));
								headDoc.setPassword(rs.getString("password"));
								headDoc.setName(rs.getString("name"));
								headDoc.setType(rs.getString("type"));
								HeadDoctorGUI hDGUI = new HeadDoctorGUI(headDoc);
								hDGUI.setVisible(true);
								dispose();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDoctorEnter.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDoctorEnter.setBackground(new Color(50, 205, 50));
		btnDoctorEnter.setBounds(197, 196, 236, 55);
		wDoctorLogin.add(btnDoctorEnter);
		
		txtDoctorPassword = new JPasswordField();
		txtDoctorPassword.setBounds(284, 114, 238, 36);
		wDoctorLogin.add(txtDoctorPassword);
	}
}
