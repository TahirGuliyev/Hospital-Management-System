package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.HeadDoctor;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Util.*;

public class HeadDoctorGUI extends JFrame {
	
	static HeadDoctor headDoctor = new HeadDoctor(); 

	private JPanel wPane;
	private JTable tableDoctors;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;

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
	 * @param headDoctor 
	 * @throws SQLException 
	 */
	public HeadDoctorGUI(HeadDoctor headDoctor) throws SQLException {
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Ad Soyad";
		colDoctorName[2] = "FİN Kod";
		colDoctorName[3] = "Şifrə";
		setTitle("Xəstəxana İdarəetmə Sistemi");
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for (int i = 0; i < headDoctor.getDoctorList().size(); i++) {
			doctorData[0] = headDoctor.getDoctorList().get(i).getId();
			doctorData[1] = headDoctor.getDoctorList().get(i).getName();
			doctorData[2] = headDoctor.getDoctorList().get(i).getFinKod();
			doctorData[3] = headDoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		wPane = new JPanel();
		wPane.setBackground(new Color(224, 255, 255));
		wPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wPane);
		wPane.setLayout(null);
		
		JLabel lblWelcomeDoctor = new JLabel("Xoş gəlmisiniz, hörmətli " + headDoctor.getName());
		lblWelcomeDoctor.setBounds(22, 16, 490, 39);
		lblWelcomeDoctor.setFont(new Font("Tahoma", Font.BOLD, 14));
		wPane.add(lblWelcomeDoctor);
		
		JButton btnDoctorExit = new JButton("\u00C7IXI\u015E");
		btnDoctorExit.setBounds(578, 21, 88, 29);
		btnDoctorExit.setForeground(new Color(255, 255, 255));
		btnDoctorExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoctorExit.setBackground(new Color(220, 20, 60));
		wPane.add(btnDoctorExit);
		
		JTabbedPane wTabPane = new JTabbedPane(JTabbedPane.TOP);
		wTabPane.setBackground(new Color(224, 255, 255));
		wTabPane.setBounds(10, 97, 661, 399);
		wPane.add(wTabPane);
		
		JPanel wDoctorManage = new JPanel();
		wDoctorManage.setBackground(new Color(224, 255, 255));
		wTabPane.addTab("Həkimləri İdarə Et", null, wDoctorManage, null);
		wDoctorManage.setLayout(null);
		
		JLabel lblDoctorManageName = new JLabel("Ad Soyad");
		lblDoctorManageName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageName.setBounds(455, 23, 106, 23);
		wDoctorManage.add(lblDoctorManageName);
		
		JTextArea txtDoctorManageName = new JTextArea();
		txtDoctorManageName.setBounds(455, 48, 175, 23);
		wDoctorManage.add(txtDoctorManageName);
		
		JTextArea txtDoctorManageFinKod = new JTextArea();
		txtDoctorManageFinKod.setBounds(455, 107, 175, 23);
		wDoctorManage.add(txtDoctorManageFinKod);
		
		JLabel lblDoctorManageFinKod = new JLabel("FİN Kod");
		lblDoctorManageFinKod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageFinKod.setBounds(455, 82, 106, 23);
		wDoctorManage.add(lblDoctorManageFinKod);
		
		JTextArea txtDoctorManagePassword = new JTextArea();
		txtDoctorManagePassword.setBounds(455, 166, 175, 23);
		wDoctorManage.add(txtDoctorManagePassword);
		
		JLabel lblDoctorManagePassword = new JLabel("Şifrə");
		lblDoctorManagePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManagePassword.setBounds(455, 141, 106, 23);
		wDoctorManage.add(lblDoctorManagePassword);
		
		JButton btnDoctorManageAdd = new JButton("ƏLAVƏ ET");
		btnDoctorManageAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDoctorManageName.getText().length() == 0 || txtDoctorManagePassword.getText().length() == 0 || txtDoctorManageFinKod.getText().length() == 0) {
				Util.Helper.showMsg("fill");	
				}else {
					boolean control = headDoctor.addDoctor(txtDoctorManageFinKod.getText(), txtDoctorManagePassword.getText(), txtDoctorManageName.getText());
					if(control) {
						Util.Helper.showMsg("success");
						txtDoctorManageFinKod.setText(null);
						txtDoctorManagePassword.setText(null);
						txtDoctorManageName.setText(null);
						try {
							updateDoctorModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnDoctorManageAdd.setBackground(new Color(50, 205, 50));
		btnDoctorManageAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoctorManageAdd.setBounds(455, 201, 175, 34);
		wDoctorManage.add(btnDoctorManageAdd);
		
		JLabel lblDoctorManageUserID = new JLabel("İstifadəçi ID");
		lblDoctorManageUserID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageUserID.setBounds(455, 264, 106, 23);
		wDoctorManage.add(lblDoctorManageUserID);
		
		JTextArea txtDoctorManageUserID = new JTextArea();
		txtDoctorManageUserID.setBounds(455, 289, 175, 23);
		wDoctorManage.add(txtDoctorManageUserID);
		
		JButton btnDoctorManageDelete = new JButton("SİL");
		btnDoctorManageDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDoctorManageUserID.getText().length() == 0) {
					Util.Helper.showMsg("Zəhmət olmasa bir həkim seçin!");
				} else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(txtDoctorManageUserID.getText());
							try {
								boolean control = headDoctor.deleteDoctor(selectID);
								if(control) {
									Helper.showMsg("success");
									txtDoctorManageUserID.setText(null);
								updateDoctorModel();
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
					}
				}
			}
		});
		btnDoctorManageDelete.setForeground(new Color(255, 255, 255));
		btnDoctorManageDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoctorManageDelete.setBackground(new Color(220, 20, 60));
		btnDoctorManageDelete.setBounds(455, 323, 175, 34);
		wDoctorManage.add(btnDoctorManageDelete);
		
		JScrollPane wScrollPane = new JScrollPane();
		wScrollPane.setBounds(10, 11, 434, 346);
		wDoctorManage.add(wScrollPane);
		
		tableDoctors = new JTable(doctorModel);
		tableDoctors.setBackground(new Color(224, 255, 255));
		wScrollPane.setViewportView(tableDoctors);
		tableDoctors.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try{
					
					txtDoctorManageUserID.setText(tableDoctors.getValueAt(tableDoctors.getSelectedRow(),0).toString());
				}
				catch(Exception ex) {}
			}});
		tableDoctors.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 0).toString());
					String selectName = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 1).toString();
					String selectFinKod = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 2).toString();
					String selectPassword = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 3).toString();
					boolean control = headDoctor.updateDoctor(selectID, selectFinKod, selectPassword, selectName);
					if(control) {
						//Util.Helper.showMsg("success");
					}
				}
			}});
	}
	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableDoctors.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < headDoctor.getDoctorList().size(); i++) {
			doctorData[0] = headDoctor.getDoctorList().get(i).getId();
			doctorData[1] = headDoctor.getDoctorList().get(i).getName();
			doctorData[2] = headDoctor.getDoctorList().get(i).getFinKod();
			doctorData[3] = headDoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}
	
	
}
