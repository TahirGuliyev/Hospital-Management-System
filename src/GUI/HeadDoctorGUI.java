package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.HeadDoctor;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HeadDoctorGUI extends JFrame {
	
	static HeadDoctor headDoctor = new HeadDoctor(); 

	private JPanel wPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadDoctorGUI frame = new HeadDoctorGUI(headDoctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param headDoctor2 
	 */
	public HeadDoctorGUI(HeadDoctor headDoctor) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		wPane = new JPanel();
		wPane.setBackground(new Color(224, 255, 255));
		wPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wPane);
		wPane.setLayout(null);
		
		JLabel lblWelcomeDoctor = new JLabel("Xoş gəlmisiniz, hörmətli " + headDoctor.getName());
		lblWelcomeDoctor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeDoctor.setBounds(22, 16, 490, 39);
		wPane.add(lblWelcomeDoctor);
		
		JButton btnDoctorExit = new JButton("\u00C7IXI\u015E");
		btnDoctorExit.setForeground(new Color(255, 255, 255));
		btnDoctorExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoctorExit.setBackground(new Color(220, 20, 60));
		btnDoctorExit.setBounds(578, 21, 88, 29);
		wPane.add(btnDoctorExit);
	}
}
