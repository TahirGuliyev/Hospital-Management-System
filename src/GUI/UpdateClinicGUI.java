package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.Clinic;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {
	
	private static Clinic clinic;

	private JPanel wUpdateClinic;
	private JTextField txtClinicManageNameUpdate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateClinicGUI(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		wUpdateClinic = new JPanel();
		wUpdateClinic.setBackground(new Color(224, 255, 255));
		wUpdateClinic.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wUpdateClinic);
		wUpdateClinic.setLayout(null);
		
		JLabel lblClinicManageNameUpdate = new JLabel("Kliniki Şöbənin Adı");
		lblClinicManageNameUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClinicManageNameUpdate.setBounds(76, 11, 129, 23);
		wUpdateClinic.add(lblClinicManageNameUpdate);
		
		JButton btnClinicManageUpdate = new JButton("ƏLAVƏ ET");
		btnClinicManageUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Util.Helper.confirm("sure")) {
					clinic.updateClinic(clinic.getId(), txtClinicManageNameUpdate.getText());
					Util.Helper.showMsg("success");
					dispose();
				}
			}
		});
		btnClinicManageUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClinicManageUpdate.setBackground(new Color(50, 205, 50));
		btnClinicManageUpdate.setBounds(55, 83, 185, 34);
		wUpdateClinic.add(btnClinicManageUpdate);
		
		txtClinicManageNameUpdate = new JTextField();
		txtClinicManageNameUpdate.setBounds(55, 41, 185, 31);
		wUpdateClinic.add(txtClinicManageNameUpdate);
		txtClinicManageNameUpdate.setText(clinic.getName());
		txtClinicManageNameUpdate.setColumns(10);
	}
}
