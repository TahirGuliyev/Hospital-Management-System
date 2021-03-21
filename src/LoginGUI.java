import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class LoginGUI extends JFrame {

	private JPanel wPane;
	private JTextField txtPacientFinKod;
	private JTextField txtPacientPassword;
	private JTextField txtDoctorFinKod;
	private JTextField txtDoctorPassword;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setTitle("X\u0259st\u0259xana \u0130dar\u0259etm\u0259 Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		wPane = new JPanel();
		wPane.setBackground(Color.WHITE);
		wPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wPane);
		wPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(new ImageIcon(getClass().getResource("Medicine.jpg")));
		lblLogo.setBounds(284, 0, 66, 59);
		wPane.add(lblLogo);
		
		JLabel lblWelcomeMessageFirst = new JLabel("X\u018FST\u018FXANA \u0130DAR\u018FETM\u018F S\u0130STEM\u0130N\u018F XO\u015E G\u018FLM\u0130S\u0130N\u0130Z!");
		lblWelcomeMessageFirst.setBounds(98, 58, 439, 24);
		lblWelcomeMessageFirst.setFont(new Font("Ebrima", Font.BOLD, 16));
		wPane.add(lblWelcomeMessageFirst);
		
		JTabbedPane wTabPane = new JTabbedPane(JTabbedPane.TOP);
		wTabPane.setBounds(10, 106, 560, 342);
		wPane.add(wTabPane);
		
		JPanel wPacientLogin = new JPanel();
		wPacientLogin.setBackground(new Color(224, 255, 255));
		wTabPane.addTab("Pasient Login", null, wPacientLogin, null);
		wPacientLogin.setLayout(null);
		
		JLabel lblPacientFinKod = new JLabel("FIN kod :");
		lblPacientFinKod.setFont(new Font("Ebrima", Font.BOLD, 24));
		lblPacientFinKod.setBounds(62, 47, 161, 61);
		wPacientLogin.add(lblPacientFinKod);
		
		JLabel lblPacientPassword = new JLabel("\u015Eifr\u0259 :");
		lblPacientPassword.setFont(new Font("Ebrima", Font.BOLD, 24));
		lblPacientPassword.setBounds(62, 105, 161, 61);
		wPacientLogin.add(lblPacientPassword);
		
		txtPacientFinKod = new JTextField();
		txtPacientFinKod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPacientFinKod.setText("Fin Kodunuz...");
		txtPacientFinKod.setBounds(272, 61, 237, 41);
		wPacientLogin.add(txtPacientFinKod);
		txtPacientFinKod.setColumns(10);
		
		txtPacientPassword = new JTextField();
		txtPacientPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPacientPassword.setText("\u015Eifr\u0259niz...");
		txtPacientPassword.setColumns(10);
		txtPacientPassword.setBounds(272, 115, 237, 41);
		wPacientLogin.add(txtPacientPassword);
		
		JButton btnPacientRegister = new JButton("QEYD\u0130YYAT");
		btnPacientRegister.setFont(new Font("Verdana", Font.BOLD, 17));
		btnPacientRegister.setBackground(Color.CYAN);
		btnPacientRegister.setBounds(62, 198, 183, 61);
		wPacientLogin.add(btnPacientRegister);
		
		JButton btnPacientLogin = new JButton("GİRİŞ");
		btnPacientLogin.setFont(new Font("Verdana", Font.BOLD, 17));
		btnPacientLogin.setBackground(Color.GREEN);
		btnPacientLogin.setBounds(297, 198, 212, 61);
		wPacientLogin.add(btnPacientLogin);
		
		JPanel wDoctorLogin = new JPanel();
		wDoctorLogin.setBackground(new Color(224, 255, 255));
		wTabPane.addTab("Həkim Login", null, wDoctorLogin, null);
		wDoctorLogin.setLayout(null);
		
		JLabel lblDoctorFinKod = new JLabel("FIN kod :");
		lblDoctorFinKod.setFont(new Font("Ebrima", Font.BOLD, 24));
		lblDoctorFinKod.setBounds(53, 41, 161, 61);
		wDoctorLogin.add(lblDoctorFinKod);
		
		txtDoctorFinKod = new JTextField();
		txtDoctorFinKod.setText("Fin Kodunuz...");
		txtDoctorFinKod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDoctorFinKod.setColumns(10);
		txtDoctorFinKod.setBounds(263, 55, 237, 41);
		wDoctorLogin.add(txtDoctorFinKod);
		
		txtDoctorPassword = new JTextField();
		txtDoctorPassword.setText("\u015Eifr\u0259niz...");
		txtDoctorPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDoctorPassword.setColumns(10);
		txtDoctorPassword.setBounds(263, 109, 237, 41);
		wDoctorLogin.add(txtDoctorPassword);
		
		JLabel lblDoctorPassword = new JLabel("\u015Eifr\u0259 :");
		lblDoctorPassword.setFont(new Font("Ebrima", Font.BOLD, 24));
		lblDoctorPassword.setBounds(53, 99, 161, 61);
		wDoctorLogin.add(lblDoctorPassword);
		
		JButton btnDoctorLogin = new JButton("GİRİŞ");
		btnDoctorLogin.setFont(new Font("Verdana", Font.BOLD, 17));
		btnDoctorLogin.setBackground(Color.GREEN);
		btnDoctorLogin.setBounds(53, 192, 447, 61);
		wDoctorLogin.add(btnDoctorLogin);
	}
}
